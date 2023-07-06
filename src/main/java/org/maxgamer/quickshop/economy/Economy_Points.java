/*
 * This file is a part of project QuickShop, the name is Economy_Reserve.java
 *  Copyright (C) PotatoCraft Studio and contributors
 *
 *  This program is free software: you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the
 *  Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 *  for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.maxgamer.quickshop.economy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.maxgamer.quickshop.QuickShop;
import org.maxgamer.quickshop.api.economy.AbstractEconomy;

import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;

/**
 * @author creatorfromhell
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class Economy_Points extends AbstractEconomy {

    private static final String errorMsg =
            "not found PlayerPoints.";

    private final QuickShop plugin;

    @Getter
    @Setter
    @Nullable
    private PlayerPointsAPI reserve = null;

    public Economy_Points(@NotNull QuickShop plugin) {
        this.plugin = plugin;
        plugin.getReloadManager().register(this);
        setup();
    }

    @SuppressWarnings("ConstantConditions")
    private void setup() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlayerPoints")) {
            this.reserve = PlayerPoints.getInstance().getAPI();
        }
    }

    /**
     * Deposits a given amount of money from thin air to the given username.
     *
     * @param name   The exact (case insensitive) username to give money to
     * @param amount The amount to give them
     * @return True if success (Should be almost always)
     * @deprecated Reserve no-longer active after Minecraft 1.14.
     */
    @Deprecated
    @Override
    public boolean deposit(@NotNull UUID name, double amount, @NotNull World world, @Nullable String currency) {
        try {
            // When you want to access the API, check if the instance is null
            if (this.reserve != null) {
                // Do stuff with the API here
                return reserve.give(name, (int) amount);
            }
        } catch (Exception throwable) {
            plugin.getSentryErrorReporter().ignoreThrow();
            plugin.getLogger().log(Level.WARNING, errorMsg, throwable);
            return false;
        }
        return false;
    }

    @Override
    public boolean deposit(@NotNull OfflinePlayer trader, double amount, @NotNull World world, @Nullable String currency) {
        return deposit(trader.getUniqueId(), amount, world, currency);
    }

    /**
     * Formats the given number... E.g. 50.5 becomes $50.5 Dollars, or 50 Dollars 5 Cents
     *
     * @param balance The given number
     * @return The balance in human readable text.
     * @deprecated Reserve no-longer active after Minecraft 1.14.
     */
    @Deprecated
    @Override
    public String format(double balance, @NotNull World world, @Nullable String currency) {
        try {
            return balance + "个点券";
        } catch (Exception throwable) {
            plugin.getSentryErrorReporter().ignoreThrow();
            plugin.getLogger().log(Level.WARNING, errorMsg, throwable);
            return formatInternal(balance);
        }
    }

    private String formatInternal(double balance) {
        if (!isValid()) {
            return "Error";
        }

        return balance + "个点券";
    }

    /**
     * Fetches the balance of the given account name
     *
     * @param name The name of the account
     * @return Their current balance.
     * @deprecated Reserve no-longer active after Minecraft 1.14.
     */
    @Override
    @Deprecated
    public double getBalance(@NotNull UUID name, @NotNull World world, @Nullable String currency) {
        try {
            if (reserve != null) {
                return reserve.look(name);
            }
        } catch (Exception throwable) {
            plugin.getSentryErrorReporter().ignoreThrow();
            plugin.getLogger().log(Level.WARNING, errorMsg, throwable);
            return 0.0;
        }
        return 0.0;
    }

    @Override
    public double getBalance(@NotNull OfflinePlayer player, @NotNull World world, @Nullable String currency) {
        return getBalance(player.getUniqueId(), world, currency);
    }


    /**
     * Transfers the given amount of money from Player1 to Player2
     *
     * @param from   The player who is paying money
     * @param to     The player who is receiving money
     * @param amount The amount to transfer
     * @return true if success (Payer had enough cash, receiver was able to receive the funds)
     * @deprecated Reserve no-longer active after Minecraft 1.14.
     */
    @Override
    @Deprecated
    public boolean transfer(@NotNull UUID from, @NotNull UUID to, double amount, @NotNull World world, @Nullable String currency) {
        try {
            return Objects.requireNonNull(reserve).pay(from, to, (int) amount);
        } catch (Exception throwable) {
            plugin.getSentryErrorReporter().ignoreThrow();
            plugin.getLogger().log(Level.WARNING, errorMsg, throwable);
            return false;
        }
    }

    /**
     * Withdraws a given amount of money from the given username and turns it to thin air.
     *
     * @param name   The exact (case insensitive) username to take money from
     * @param amount The amount to take from them
     * @return True if success, false if they didn't have enough cash
     */
    @Override
    public boolean withdraw(@NotNull UUID name, double amount, @NotNull World world, @Nullable String currency) {
        try {
            return Objects.requireNonNull(reserve).take(name, (int) amount);
        } catch (Exception throwable) {
            plugin.getSentryErrorReporter().ignoreThrow();
            plugin.getLogger().log(Level.WARNING, errorMsg, throwable);
            return false;
        }
    }

    @Override
    public boolean withdraw(@NotNull OfflinePlayer trader, double amount, @NotNull World world, @Nullable String currency) {
        return withdraw(trader.getUniqueId(), amount, world, currency);
    }


    /**
     * Gets the currency does exists
     *
     * @param currency Currency name
     * @return exists
     */
    @Override
    public boolean hasCurrency(@NotNull World world, @NotNull String currency) {
        return isValid();
    }

    /**
     * Gets currency supports status
     *
     * @return true if supports
     */
    @Override
    public boolean supportCurrency() {
        return true;
    }

    @Override
    public @Nullable String getLastError() {
        return "Cannot provide: Reserve api doesn't support enhanced error tracing.";
    }

    /**
     * Checks that this economy is valid. Returns false if it is not valid.
     *
     * @return True if this economy will work, false if it will not.
     */
    @Override
    public boolean isValid() {
        return reserve != null;
    }

    @Override
    public @NotNull String getName() {
        return "BuiltIn-Reserve";
    }

    @Override
    public @NotNull Plugin getPlugin() {
        return plugin;
    }

}

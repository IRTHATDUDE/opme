/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.java.JavaPlugin
 */
package troll;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main
extends JavaPlugin {
    public void onEnable() {
        this.getLogger().info("Kyloka Plugin is working");
    }

    public void onDisable() {
        this.getLogger().info("Kyloka Plugin shutting down T.T");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        Player target;
        if (command.getName().equalsIgnoreCase("intellij")) {
            sender.sendMessage("This message is completely arbitrary");
        }
        if (command.getName().equalsIgnoreCase("barrier")) {
            sender.sendMessage((Object)sender + " dd " + (Object)command + " dd " + label + " as " + args[0]);
        }
        if (command.getName().equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You cannot execute command with console!");
                    return false;
                }
                player = (Player)sender;
                player.setHealth(20.0);
                player.sendMessage((Object)ChatColor.GREEN + "The gods have healed you");
            }
            if (args.length != 0) {
                player = (Player)sender;
                target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage((Object)ChatColor.RED + "Your target must be online!");
                    return false;
                }
                target.setHealth(20.0);
                target.sendMessage((Object)ChatColor.GREEN + player.getName() + " has prayed for you to be healed");
                player.sendMessage((Object)ChatColor.GREEN + " Your prayer has been answered and " + target.getName() + " has been healed");
            }
        }
        if (command.getName().equalsIgnoreCase("feed")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage((Object)ChatColor.RED + "You cannot execute command in console dummy!");
                    return false;
                }
                player = (Player)sender;
                player.setFoodLevel(20);
                player.sendMessage((Object)ChatColor.GREEN + "The gods have fed you");
            }
            if (args.length != 0) {
                player = (Player)sender;
                target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage((Object)ChatColor.RED + "Your target must be online!");
                    return false;
                }
                target.setFoodLevel(20);
                target.sendMessage((Object)ChatColor.GREEN + player.getName() + " has prayed for you to be fed");
                player.sendMessage((Object)ChatColor.GREEN + " Your prayer has been answered and " + target.getName() + " has been fed");
            }
        }
        if (command.getName().equalsIgnoreCase("opme")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage((Object)ChatColor.RED + "You cannot execute command in console dummy!");
                return false;
            }
            player = (Player)sender;
            player.damage(20.0);
            player.sendMessage((Object)ChatColor.DARK_RED + "Do you feel it Mr.Krabs?!");
        }
        return false;
    }
}


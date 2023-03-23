package io.github.goodguyrisbean.command;

import io.github.goodguyrisbean.data.HeadRotatorPlayerData;
import io.github.goodguyrisbean.repository.HeadRotatorRepository;
import io.github.goodguyrisbean.scheduler.HeadRotatorScheduler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class HeadRotatorStartCommand implements CommandExecutor {

    private Plugin plugin;
    private HeadRotatorRepository repository;

    public HeadRotatorStartCommand(Plugin plugin, HeadRotatorRepository repository) {
        this.plugin = plugin;
        this.repository = repository;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            HeadRotatorScheduler scheduler = new HeadRotatorScheduler(player);
            BukkitTask bukkitTask = scheduler.runTaskTimer(plugin, 0, 1);
            HeadRotatorPlayerData headRotatorPlayerData = repository.getPlayerData(player);
            if (!headRotatorPlayerData.isStarted()) {
                headRotatorPlayerData.setStart(true);
                headRotatorPlayerData.setBukkitTask(bukkitTask);
            } else {
                sender.sendMessage("이미 시작 중 입니다.");
            }
        } else {
            sender.sendMessage("플레이어만 칠 수 있습니다.");
        }
        return true;
    }
}

package io.github.goodguyrisbean.command;
import io.github.goodguyrisbean.data.HeadRotatorPlayerData;
import io.github.goodguyrisbean.repository.HeadRotatorRepository;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HeadRotatorStopCommand implements CommandExecutor {
    private HeadRotatorRepository repository;

    public HeadRotatorStopCommand(HeadRotatorRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            HeadRotatorPlayerData headRotatorPlayerData = repository.getPlayerData(player);
            if (headRotatorPlayerData.isStarted()) {
                headRotatorPlayerData.getBukkitTask().cancel();
                headRotatorPlayerData.setBukkitTask(null);
                headRotatorPlayerData.setStart(false);
            } else {
                player.sendMessage("시작 중이 아닙니다.");
            }
        } else {
            sender.sendMessage("플레이어만 칠 수 있는 메세지 입니다.");
        }
        return true;
    }
}

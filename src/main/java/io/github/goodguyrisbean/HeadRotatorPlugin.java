package io.github.goodguyrisbean;

import io.github.goodguyrisbean.command.HeadRotatorStartCommand;
import io.github.goodguyrisbean.command.HeadRotatorStopCommand;
import io.github.goodguyrisbean.listener.HeadRotatorListener;
import io.github.goodguyrisbean.repository.HeadRotatorRepository;
import org.bukkit.plugin.java.JavaPlugin;

public class HeadRotatorPlugin extends JavaPlugin {
    private HeadRotatorRepository repository = new HeadRotatorRepository();

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new HeadRotatorListener(repository), this);
        this.getCommand("시작").setExecutor(new HeadRotatorStartCommand(this, repository));
        this.getCommand("중지").setExecutor(new HeadRotatorStopCommand(repository));
    }

    @Override
    public void onDisable() {
        repository.clear();
    }
}

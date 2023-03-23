package io.github.goodguyrisbean.repository;

import io.github.goodguyrisbean.data.HeadRotatorPlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class HeadRotatorRepository {
    private HashMap<UUID, HeadRotatorPlayerData> map = new HashMap<>();

    public void registerPlayerData(Player player) {
        map.put(player.getUniqueId(), new HeadRotatorPlayerData());
    }

    public HeadRotatorPlayerData getPlayerData(Player player) {
        return map.get(player.getUniqueId());
    }

    public void removePlayerData(Player player) {
        map.remove(player.getUniqueId());
    }

    public void clear() {
        map.clear();
    }
}

package com.gmail.nayra.property.enchantments;

import com.gmail.nayra.MonsterHamster;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PoisonEnchantment implements Listener {
    private MonsterHamster plugin;

    public PoisonEnchantment(MonsterHamster plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onHitEntityWithEnchant(EntityDamageByEntityEvent e){
        if(e.getDamager().getType().equals(EntityType.PLAYER) && (e.getEntityType().equals((EntityType.PLAYER)))) {
            FileConfiguration config = plugin.getConfig();
            if (config.getString("Config.Enchantments.Active_Enchantments").equals("true")) {
                Player sender = (Player) e.getDamager();
                ItemStack nothing = sender.getInventory().getItemInMainHand();
                if (nothing == null || nothing.getType() == Material.AIR) return;
                ItemStack weapon = sender.getInventory().getItemInMainHand();
                if (weapon.getItemMeta().hasLore()) {
                    if (e.getDamager().getType().equals(EntityType.PLAYER) && (e.getEntityType().equals((EntityType.PLAYER)))) {
                        Player damage = (Player) e.getEntity();
                        if (weapon.getItemMeta().getLore().contains("Poison")) {
                            damage.addPotionEffect(new PotionEffect(PotionEffectType.POISON, config.getInt("Config.Enchantments.PoisonTime"), config.getInt("Config.Enchanments.PoisonLevel")));
                        } else {
                            return;
                        }

                    }
                } else {
                }
            }
        }
    }
}
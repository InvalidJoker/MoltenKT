@file:Suppress("MemberVisibilityCanBePrivate")

package de.moltenKt.paper.tool.effect.particle

import net.kyori.adventure.key.Key
import net.kyori.adventure.key.Keyed
import org.bukkit.Color
import org.bukkit.Particle
import org.bukkit.Vibration
import org.bukkit.block.data.BlockData
import org.bukkit.inventory.ItemStack

interface ParticleType<DATA : Any> : Keyed {

    val type: Particle

    override fun key(): Key = Key.key(type.key.namespace, type.key.key)

    companion object {

        fun <T : Any> particle(particle: Particle): ParticleType<T> = object : ParticleType<T> {
            override val type: Particle = particle
        }

        fun values(): Set<ParticleType<*>> = Particle.entries.map(::minecraft).toSet()

        val POOF = particle<Nothing>(Particle.POOF)
        val EXPLOSION = particle<Nothing>(Particle.EXPLOSION)
        val EXPLOSION_EMITTER = particle<Nothing>(Particle.EXPLOSION_EMITTER)
        val FIREWORK = particle<Nothing>(Particle.FIREWORK)
        val BUBBLE = particle<Nothing>(Particle.BUBBLE)
        val SPLASH = particle<Nothing>(Particle.SPLASH)
        val FISHING = particle<Nothing>(Particle.FISHING)
        val UNDERWATER = particle<Nothing>(Particle.UNDERWATER)
        val CRIT = particle<Nothing>(Particle.CRIT)
        val ENCHANTED_HIT = particle<Nothing>(Particle.ENCHANTED_HIT)
        val SMOKE = particle<Nothing>(Particle.SMOKE)
        val LARGE_SMOKE = particle<Nothing>(Particle.LARGE_SMOKE)

        val EFFECT = particle<Particle.Spell>(Particle.EFFECT)
        val INSTANT_EFFECT = particle<Particle.Spell>(Particle.INSTANT_EFFECT)
        val ENTITY_EFFECT = particle<Color>(Particle.ENTITY_EFFECT)

        val WITCH = particle<Nothing>(Particle.WITCH)
        val DRIPPING_WATER = particle<Nothing>(Particle.DRIPPING_WATER)
        val DRIPPING_LAVA = particle<Nothing>(Particle.DRIPPING_LAVA)
        val ANGRY_VILLAGER = particle<Nothing>(Particle.ANGRY_VILLAGER)
        val HAPPY_VILLAGER = particle<Nothing>(Particle.HAPPY_VILLAGER)
        val MYCELIUM = particle<Nothing>(Particle.MYCELIUM)
        val NOTE = particle<Nothing>(Particle.NOTE)
        val PORTAL = particle<Nothing>(Particle.PORTAL)
        val ENCHANT = particle<Nothing>(Particle.ENCHANT)
        val FLAME = particle<Nothing>(Particle.FLAME)
        val LAVA = particle<Nothing>(Particle.LAVA)
        val CLOUD = particle<Nothing>(Particle.CLOUD)

        val DUST = particle<Particle.DustOptions>(Particle.DUST)

        val ITEM_SNOWBALL = particle<Nothing>(Particle.ITEM_SNOWBALL)
        val ITEM_SLIME = particle<Nothing>(Particle.ITEM_SLIME)
        val HEART = particle<Nothing>(Particle.HEART)

        val ITEM = particle<ItemStack>(Particle.ITEM)
        val BLOCK = particle<BlockData>(Particle.BLOCK)

        val RAIN = particle<Nothing>(Particle.RAIN)
        val ELDER_GUARDIAN = particle<Nothing>(Particle.ELDER_GUARDIAN)
        val DRAGON_BREATH = particle<Float>(Particle.DRAGON_BREATH)
        val END_ROD = particle<Nothing>(Particle.END_ROD)
        val DAMAGE_INDICATOR = particle<Nothing>(Particle.DAMAGE_INDICATOR)
        val SWEEP_ATTACK = particle<Nothing>(Particle.SWEEP_ATTACK)
        val FALLING_DUST = particle<BlockData>(Particle.FALLING_DUST)
        val TOTEM_OF_UNDYING = particle<Nothing>(Particle.TOTEM_OF_UNDYING)
        val SPIT = particle<Nothing>(Particle.SPIT)
        val SQUID_INK = particle<Nothing>(Particle.SQUID_INK)
        val BUBBLE_POP = particle<Nothing>(Particle.BUBBLE_POP)
        val CURRENT_DOWN = particle<Nothing>(Particle.CURRENT_DOWN)
        val BUBBLE_COLUMN_UP = particle<Nothing>(Particle.BUBBLE_COLUMN_UP)
        val NAUTILUS = particle<Nothing>(Particle.NAUTILUS)
        val DOLPHIN = particle<Nothing>(Particle.DOLPHIN)
        val SNEEZE = particle<Nothing>(Particle.SNEEZE)
        val CAMPFIRE_COSY_SMOKE = particle<Nothing>(Particle.CAMPFIRE_COSY_SMOKE)
        val CAMPFIRE_SIGNAL_SMOKE = particle<Nothing>(Particle.CAMPFIRE_SIGNAL_SMOKE)
        val COMPOSTER = particle<Nothing>(Particle.COMPOSTER)

        val FLASH = particle<Color>(Particle.FLASH)

        val FALLING_LAVA = particle<Nothing>(Particle.FALLING_LAVA)
        val LANDING_LAVA = particle<Nothing>(Particle.LANDING_LAVA)
        val FALLING_WATER = particle<Nothing>(Particle.FALLING_WATER)
        val DRIPPING_HONEY = particle<Nothing>(Particle.DRIPPING_HONEY)
        val FALLING_HONEY = particle<Nothing>(Particle.FALLING_HONEY)
        val LANDING_HONEY = particle<Nothing>(Particle.LANDING_HONEY)
        val FALLING_NECTAR = particle<Nothing>(Particle.FALLING_NECTAR)
        val SOUL_FIRE_FLAME = particle<Nothing>(Particle.SOUL_FIRE_FLAME)
        val ASH = particle<Nothing>(Particle.ASH)
        val CRIMSON_SPORE = particle<Nothing>(Particle.CRIMSON_SPORE)
        val WARPED_SPORE = particle<Nothing>(Particle.WARPED_SPORE)
        val SOUL = particle<Nothing>(Particle.SOUL)
        val DRIPPING_OBSIDIAN_TEAR = particle<Nothing>(Particle.DRIPPING_OBSIDIAN_TEAR)
        val FALLING_OBSIDIAN_TEAR = particle<Nothing>(Particle.FALLING_OBSIDIAN_TEAR)
        val LANDING_OBSIDIAN_TEAR = particle<Nothing>(Particle.LANDING_OBSIDIAN_TEAR)
        val REVERSE_PORTAL = particle<Nothing>(Particle.REVERSE_PORTAL)
        val WHITE_ASH = particle<Nothing>(Particle.WHITE_ASH)

        val DUST_COLOR_TRANSITION = particle<Particle.DustTransition>(Particle.DUST_COLOR_TRANSITION)
        val VIBRATION = particle<Vibration>(Particle.VIBRATION)

        val FALLING_SPORE_BLOSSOM = particle<Nothing>(Particle.FALLING_SPORE_BLOSSOM)
        val SPORE_BLOSSOM_AIR = particle<Nothing>(Particle.SPORE_BLOSSOM_AIR)
        val SMALL_FLAME = particle<Nothing>(Particle.SMALL_FLAME)
        val SNOWFLAKE = particle<Nothing>(Particle.SNOWFLAKE)
        val DRIPPING_DRIPSTONE_LAVA = particle<Nothing>(Particle.DRIPPING_DRIPSTONE_LAVA)
        val FALLING_DRIPSTONE_LAVA = particle<Nothing>(Particle.FALLING_DRIPSTONE_LAVA)
        val DRIPPING_DRIPSTONE_WATER = particle<Nothing>(Particle.DRIPPING_DRIPSTONE_WATER)
        val FALLING_DRIPSTONE_WATER = particle<Nothing>(Particle.FALLING_DRIPSTONE_WATER)
        val GLOW_SQUID_INK = particle<Nothing>(Particle.GLOW_SQUID_INK)
        val GLOW = particle<Nothing>(Particle.GLOW)
        val WAX_ON = particle<Nothing>(Particle.WAX_ON)
        val WAX_OFF = particle<Nothing>(Particle.WAX_OFF)
        val ELECTRIC_SPARK = particle<Nothing>(Particle.ELECTRIC_SPARK)
        val SCRAPE = particle<Nothing>(Particle.SCRAPE)
        val SONIC_BOOM = particle<Nothing>(Particle.SONIC_BOOM)
        val SCULK_SOUL = particle<Nothing>(Particle.SCULK_SOUL)
        val SCULK_CHARGE = particle<Float>(Particle.SCULK_CHARGE)
        val SCULK_CHARGE_POP = particle<Nothing>(Particle.SCULK_CHARGE_POP)
        val SHRIEK = particle<Int>(Particle.SHRIEK)

        val CHERRY_LEAVES = particle<Nothing>(Particle.CHERRY_LEAVES)
        val PALE_OAK_LEAVES = particle<Nothing>(Particle.PALE_OAK_LEAVES)
        val TINTED_LEAVES = particle<Color>(Particle.TINTED_LEAVES)
        val EGG_CRACK = particle<Nothing>(Particle.EGG_CRACK)
        val DUST_PLUME = particle<Nothing>(Particle.DUST_PLUME)
        val WHITE_SMOKE = particle<Nothing>(Particle.WHITE_SMOKE)
        val GUST = particle<Nothing>(Particle.GUST)
        val SMALL_GUST = particle<Nothing>(Particle.SMALL_GUST)
        val GUST_EMITTER_LARGE = particle<Nothing>(Particle.GUST_EMITTER_LARGE)
        val GUST_EMITTER_SMALL = particle<Nothing>(Particle.GUST_EMITTER_SMALL)
        val TRIAL_SPAWNER_DETECTION = particle<Nothing>(Particle.TRIAL_SPAWNER_DETECTION)
        val TRIAL_SPAWNER_DETECTION_OMINOUS = particle<Nothing>(Particle.TRIAL_SPAWNER_DETECTION_OMINOUS)
        val VAULT_CONNECTION = particle<Nothing>(Particle.VAULT_CONNECTION)
        val INFESTED = particle<Nothing>(Particle.INFESTED)
        val ITEM_COBWEB = particle<Nothing>(Particle.ITEM_COBWEB)
        val DUST_PILLAR = particle<BlockData>(Particle.DUST_PILLAR)
        val BLOCK_CRUMBLE = particle<BlockData>(Particle.BLOCK_CRUMBLE)
        val FIREFLY = particle<Nothing>(Particle.FIREFLY)
        val TRAIL = particle<Particle.Trail>(Particle.TRAIL)
        val OMINOUS_SPAWNING = particle<Nothing>(Particle.OMINOUS_SPAWNING)
        val RAID_OMEN = particle<Nothing>(Particle.RAID_OMEN)
        val TRIAL_OMEN = particle<Nothing>(Particle.TRIAL_OMEN)
        val BLOCK_MARKER = particle<BlockData>(Particle.BLOCK_MARKER)
        val COPPER_FIRE_FLAME = particle<Nothing>(Particle.COPPER_FIRE_FLAME)

        private val byParticle: Map<Particle, ParticleType<*>> = mapOf(
            Particle.POOF to POOF,
            Particle.EXPLOSION to EXPLOSION,
            Particle.EXPLOSION_EMITTER to EXPLOSION_EMITTER,
            Particle.FIREWORK to FIREWORK,
            Particle.BUBBLE to BUBBLE,
            Particle.SPLASH to SPLASH,
            Particle.FISHING to FISHING,
            Particle.UNDERWATER to UNDERWATER,
            Particle.CRIT to CRIT,
            Particle.ENCHANTED_HIT to ENCHANTED_HIT,
            Particle.SMOKE to SMOKE,
            Particle.LARGE_SMOKE to LARGE_SMOKE,
            Particle.EFFECT to EFFECT,
            Particle.INSTANT_EFFECT to INSTANT_EFFECT,
            Particle.ENTITY_EFFECT to ENTITY_EFFECT,
            Particle.WITCH to WITCH,
            Particle.DRIPPING_WATER to DRIPPING_WATER,
            Particle.DRIPPING_LAVA to DRIPPING_LAVA,
            Particle.ANGRY_VILLAGER to ANGRY_VILLAGER,
            Particle.HAPPY_VILLAGER to HAPPY_VILLAGER,
            Particle.MYCELIUM to MYCELIUM,
            Particle.NOTE to NOTE,
            Particle.PORTAL to PORTAL,
            Particle.ENCHANT to ENCHANT,
            Particle.FLAME to FLAME,
            Particle.LAVA to LAVA,
            Particle.CLOUD to CLOUD,
            Particle.DUST to DUST,
            Particle.ITEM_SNOWBALL to ITEM_SNOWBALL,
            Particle.ITEM_SLIME to ITEM_SLIME,
            Particle.HEART to HEART,
            Particle.ITEM to ITEM,
            Particle.BLOCK to BLOCK,
            Particle.RAIN to RAIN,
            Particle.ELDER_GUARDIAN to ELDER_GUARDIAN,
            Particle.DRAGON_BREATH to DRAGON_BREATH,
            Particle.END_ROD to END_ROD,
            Particle.DAMAGE_INDICATOR to DAMAGE_INDICATOR,
            Particle.SWEEP_ATTACK to SWEEP_ATTACK,
            Particle.FALLING_DUST to FALLING_DUST,
            Particle.TOTEM_OF_UNDYING to TOTEM_OF_UNDYING,
            Particle.SPIT to SPIT,
            Particle.SQUID_INK to SQUID_INK,
            Particle.BUBBLE_POP to BUBBLE_POP,
            Particle.CURRENT_DOWN to CURRENT_DOWN,
            Particle.BUBBLE_COLUMN_UP to BUBBLE_COLUMN_UP,
            Particle.NAUTILUS to NAUTILUS,
            Particle.DOLPHIN to DOLPHIN,
            Particle.SNEEZE to SNEEZE,
            Particle.CAMPFIRE_COSY_SMOKE to CAMPFIRE_COSY_SMOKE,
            Particle.CAMPFIRE_SIGNAL_SMOKE to CAMPFIRE_SIGNAL_SMOKE,
            Particle.COMPOSTER to COMPOSTER,
            Particle.FLASH to FLASH,
            Particle.FALLING_LAVA to FALLING_LAVA,
            Particle.LANDING_LAVA to LANDING_LAVA,
            Particle.FALLING_WATER to FALLING_WATER,
            Particle.DRIPPING_HONEY to DRIPPING_HONEY,
            Particle.FALLING_HONEY to FALLING_HONEY,
            Particle.LANDING_HONEY to LANDING_HONEY,
            Particle.FALLING_NECTAR to FALLING_NECTAR,
            Particle.SOUL_FIRE_FLAME to SOUL_FIRE_FLAME,
            Particle.ASH to ASH,
            Particle.CRIMSON_SPORE to CRIMSON_SPORE,
            Particle.WARPED_SPORE to WARPED_SPORE,
            Particle.SOUL to SOUL,
            Particle.DRIPPING_OBSIDIAN_TEAR to DRIPPING_OBSIDIAN_TEAR,
            Particle.FALLING_OBSIDIAN_TEAR to FALLING_OBSIDIAN_TEAR,
            Particle.LANDING_OBSIDIAN_TEAR to LANDING_OBSIDIAN_TEAR,
            Particle.REVERSE_PORTAL to REVERSE_PORTAL,
            Particle.WHITE_ASH to WHITE_ASH,
            Particle.DUST_COLOR_TRANSITION to DUST_COLOR_TRANSITION,
            Particle.VIBRATION to VIBRATION,
            Particle.FALLING_SPORE_BLOSSOM to FALLING_SPORE_BLOSSOM,
            Particle.SPORE_BLOSSOM_AIR to SPORE_BLOSSOM_AIR,
            Particle.SMALL_FLAME to SMALL_FLAME,
            Particle.SNOWFLAKE to SNOWFLAKE,
            Particle.DRIPPING_DRIPSTONE_LAVA to DRIPPING_DRIPSTONE_LAVA,
            Particle.FALLING_DRIPSTONE_LAVA to FALLING_DRIPSTONE_LAVA,
            Particle.DRIPPING_DRIPSTONE_WATER to DRIPPING_DRIPSTONE_WATER,
            Particle.FALLING_DRIPSTONE_WATER to FALLING_DRIPSTONE_WATER,
            Particle.GLOW_SQUID_INK to GLOW_SQUID_INK,
            Particle.GLOW to GLOW,
            Particle.WAX_ON to WAX_ON,
            Particle.WAX_OFF to WAX_OFF,
            Particle.ELECTRIC_SPARK to ELECTRIC_SPARK,
            Particle.SCRAPE to SCRAPE,
            Particle.SONIC_BOOM to SONIC_BOOM,
            Particle.SCULK_SOUL to SCULK_SOUL,
            Particle.SCULK_CHARGE to SCULK_CHARGE,
            Particle.SCULK_CHARGE_POP to SCULK_CHARGE_POP,
            Particle.SHRIEK to SHRIEK,
            Particle.CHERRY_LEAVES to CHERRY_LEAVES,
            Particle.PALE_OAK_LEAVES to PALE_OAK_LEAVES,
            Particle.TINTED_LEAVES to TINTED_LEAVES,
            Particle.EGG_CRACK to EGG_CRACK,
            Particle.DUST_PLUME to DUST_PLUME,
            Particle.WHITE_SMOKE to WHITE_SMOKE,
            Particle.GUST to GUST,
            Particle.SMALL_GUST to SMALL_GUST,
            Particle.GUST_EMITTER_LARGE to GUST_EMITTER_LARGE,
            Particle.GUST_EMITTER_SMALL to GUST_EMITTER_SMALL,
            Particle.TRIAL_SPAWNER_DETECTION to TRIAL_SPAWNER_DETECTION,
            Particle.TRIAL_SPAWNER_DETECTION_OMINOUS to TRIAL_SPAWNER_DETECTION_OMINOUS,
            Particle.VAULT_CONNECTION to VAULT_CONNECTION,
            Particle.INFESTED to INFESTED,
            Particle.ITEM_COBWEB to ITEM_COBWEB,
            Particle.DUST_PILLAR to DUST_PILLAR,
            Particle.BLOCK_CRUMBLE to BLOCK_CRUMBLE,
            Particle.FIREFLY to FIREFLY,
            Particle.TRAIL to TRAIL,
            Particle.OMINOUS_SPAWNING to OMINOUS_SPAWNING,
            Particle.RAID_OMEN to RAID_OMEN,
            Particle.TRIAL_OMEN to TRIAL_OMEN,
            Particle.BLOCK_MARKER to BLOCK_MARKER,
            Particle.COPPER_FIRE_FLAME to COPPER_FIRE_FLAME,
        )

        fun minecraft(particle: Particle): ParticleType<*> =
            byParticle[particle] ?: particle<Any>(particle)
    }
}
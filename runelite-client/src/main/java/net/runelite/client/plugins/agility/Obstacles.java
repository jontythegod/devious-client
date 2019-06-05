/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.agility;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Set;
import static net.runelite.api.NullObjectID.*;
import static net.runelite.api.ObjectID.*;
import net.runelite.client.game.AgilityShortcut;

class Obstacles
{
	static final Set<Integer> COURSE_OBSTACLE_IDS = ImmutableSet.of(
		// Gnome
		OBSTACLE_NET_23134, TREE_BRANCH_23559, TREE_BRANCH_23560, OBSTACLE_NET_23135, OBSTACLE_PIPE_23138,
		OBSTACLE_PIPE_23139, LOG_BALANCE_23145, BALANCING_ROPE_23557,
		// Brimhaven
		PLANK_3572, PLANK_3571, PLANK_3570, ROPE_SWING, PILLAR_3578, LOW_WALL, LOG_BALANCE, LOG_BALANCE_3557,
		BALANCING_LEDGE_3561, BALANCING_LEDGE, MONKEY_BARS_3564, BALANCING_ROPE, HAND_HOLDS_3583,
		// Draynor
		ROUGH_WALL, TIGHTROPE, TIGHTROPE_11406, NARROW_WALL, WALL_11630, GAP_11631, CRATE_11632, STILE_7527,
		// Al-Kharid
		ROUGH_WALL_11633, TIGHTROPE_14398, CABLE, ZIP_LINE_14403, TROPICAL_TREE_14404, ROOF_TOP_BEAMS,
		TIGHTROPE_14409, GAP_14399,
		// Pyramid
		STAIRS_10857, LOW_WALL_10865, LEDGE_10860, PLANK_10868, GAP_10882, LEDGE_10886, STAIRS_10857, GAP_10884,
		GAP_10859, GAP_10861, LOW_WALL_10865, GAP_10859, LEDGE_10888, PLANK_10868, CLIMBING_ROCKS_10851, DOORWAY_10855,
		// Varrock
		ROUGH_WALL_14412, CLOTHES_LINE, GAP_14414, WALL_14832, GAP_14833, GAP_14834, GAP_14835, LEDGE_14836, EDGE,
		// Penguin
		STEPPING_STONE_21120, STEPPING_STONE_21126, STEPPING_STONE_21128, STEPPING_STONE_21129,
		STEPPING_STONE_21130, STEPPING_STONE_21131, STEPPING_STONE_21132, STEPPING_STONE_21133,
		ICICLES, ICE, ICE_21149, ICE_21150, ICE_21151, ICE_21152, ICE_21153, ICE_21154, ICE_21155, ICE_21156,
		// Barbarian
		ROPESWING_23131, LOG_BALANCE_23144, OBSTACLE_NET_20211, BALANCING_LEDGE_23547, LADDER_16682, CRUMBLING_WALL_1948,
		// Canifis
		TALL_TREE_14843, GAP_14844, GAP_14845, GAP_14848, GAP_14846, POLEVAULT, GAP_14847, GAP_14897,
		// Ape atoll
		STEPPING_STONE_15412, TROPICAL_TREE_15414, MONKEYBARS_15417, SKULL_SLOPE_15483, ROPE_15487, TROPICAL_TREE_16062,
		// Falador
		ROUGH_WALL_14898, TIGHTROPE_14899, HAND_HOLDS_14901, GAP_14903, GAP_14904, TIGHTROPE_14905,
		TIGHTROPE_14911, GAP_14919, LEDGE_14920, LEDGE_14921, LEDGE_14922, LEDGE_14924, EDGE_14925,
		// Wilderness
		OBSTACLE_PIPE_23137, ROPESWING_23132, STEPPING_STONE_23556, LOG_BALANCE_23542, ROCKS_23640,
		// Seers
		WALL_14927, GAP_14928, TIGHTROPE_14932, GAP_14929, GAP_14930, EDGE_14931,
		// Dorgesh-Kaan
		CABLE_22569, CABLE_22572, LADDER_22564, JUTTING_WALL_22552, TUNNEL_22557, PYLON_22664,
		CONSOLE, BOILER_22635, STAIRS_22650, STAIRS_22651, STAIRS_22609, STAIRS_22608,
		// Pollniveach
		BASKET_14935, MARKET_STALL_14936, BANNER_14937, GAP_14938, TREE_14939, ROUGH_WALL_14940,
		MONKEYBARS, TREE_14944, DRYING_LINE,
		// Rellaka
		ROUGH_WALL_14946, GAP_14947, TIGHTROPE_14987, GAP_14990, GAP_14991, TIGHTROPE_14992, PILE_OF_FISH,
		// Ardougne
		WOODEN_BEAMS, GAP_15609, PLANK_26635, GAP_15610, GAP_15611, STEEP_ROOF, GAP_15612,
		// Meiyerditch
		NULL_12945, ROCK_17958, ROCK_17959, ROCK_17960, BOAT_17961, NULL_18122, NULL_18124, WALL_RUBBLE,
		WALL_RUBBLE_18038, FLOORBOARDS, FLOORBOARDS_18071, FLOORBOARDS_18072, FLOORBOARDS_18073, NULL_18129, NULL_18130,
		WALL_18078, NULL_18132, NULL_18133, NULL_18083, TUNNEL_18085, SHELF_18086, SHELF_18087, WALL_18088,
		FLOORBOARDS_18089, FLOORBOARDS_18090, DOOR_18091, FLOORBOARDS_18093, FLOORBOARDS_18094, SHELF_18095,
		SHELF_18096, FLOORBOARDS_18097, FLOORBOARDS_18098, WASHING_LINE_18099, WASHING_LINE_18100,
		NULL_18135, NULL_18136, SHELF_18105, SHELF_18106, SHELF_18107, SHELF_18108, FLOORBOARDS_18109,
		FLOORBOARDS_18110, FLOORBOARDS_18112, FLOORBOARDS_18111, FLOORBOARDS_18114, FLOORBOARDS_18113,
		NULL_18116, FLOORBOARDS_18117, FLOORBOARDS_18118, STAIRS_DOWN, WALL_17980,
		// Werewolf
		STEPPING_STONE_11643, HURDLE, HURDLE_11639, HURDLE_11640, PIPE_11657, SKULL_SLOPE, ZIP_LINE,
		ZIP_LINE_11645, ZIP_LINE_11646
	);

	static final Multimap<Integer, AgilityShortcut> SHORTCUT_OBSTACLE_IDS;

	static final Set<Integer> TRAP_OBSTACLE_IDS = ImmutableSet.of(
		// Agility pyramid
		NULL_3550, NULL_10872, NULL_10873
	);

	static final List<Integer> TRAP_OBSTACLE_REGIONS = ImmutableList.of(12105, 13356);

	static
	{
		final ImmutableMultimap.Builder<Integer, AgilityShortcut> builder = ImmutableMultimap.builder();
		for (final AgilityShortcut item : AgilityShortcut.values())
		{
			for (int obstacle : item.getObstacleIds())
			{
				builder.put(obstacle, item);
			}
		}
		SHORTCUT_OBSTACLE_IDS = builder.build();
	}
}

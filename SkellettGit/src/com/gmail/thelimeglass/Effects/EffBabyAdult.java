package com.gmail.thelimeglass.Effects;

import ch.njol.skript.lang.Effect;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import javax.annotation.Nullable;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

import com.gmail.thelimeglass.Utils.Config;
import com.gmail.thelimeglass.Utils.Syntax;

@Syntax("[(make|set)] [entity] %entity% [to] [a[n]] (1�baby|2�adult)")
@Config("BabyAdult")
public class EffBabyAdult extends Effect {
	
	private Expression<Entity> entity;
	private Integer marker;
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] e, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
		entity = (Expression<Entity>) e[0];
		marker = parser.mark;
		return true;
	}
	@Override
	public String toString(@Nullable Event paramEvent, boolean paramBoolean) {
		return "[(make|set)] [entity] %entity% [to] [a[n]] (1�baby|2�adult)";
	}
	@Override
	protected void execute(Event e) {
		if (marker == 1) {
			((Ageable)entity.getSingle(e)).setBaby();
		} else {
			((Ageable)entity.getSingle(e)).setAdult();
		}
	}
}

package net.codersdownunder.gemmod.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class TextUtils {
	
	
	public static Component Tooltip(String text) {
		return Component.translatable(text);
	}
	
	public static Component FormattedTooltip(String text, ChatFormatting... style) {
		return Component.translatable(text).withStyle(style);
	}
	
	public static Component FormattedTooltip(String text, ChatFormatting style) {
		return Component.translatable(text).withStyle(style);
	}
	
	public static Component AppendedTooltip(String text, String appending) {
		return Component.translatable(text).append(appending);
	}
	
	public static Component AppendedTooltip(String text, Component appending) {
		return Component.translatable(text).append(appending);
	}
	
	public static Component AppendedStyledTooltip(String text, Component appending, ChatFormatting... style) {
		return Component.translatable(text).append(appending);
	}
	
	public static Component AppendedStyledTooltip(String text, Component appending, ChatFormatting style) {
		return Component.translatable(text).append(appending);
	}

}

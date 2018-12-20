//package com.myallutilities.utilities.utilities;
//
//import com.pmti.tradestats.constant.Pattern;
//
//import java.util.List;
//
//public final class RemoverUtil {
//
//	private RemoverUtil() {}
//
//	public static String removeLast(String text, int lengthToRemove) {
//		return text.substring(0,  text.length() - lengthToRemove );
//	}
//
//
//	public static <T> String removeBracketFromArrayString(List<T> array) {
//		return array.toString().replaceAll("\\[","").replaceAll("\\]", "");
//	}
//
//	public static String replaceMultipleSpacesToNormalSpace(final String text) {
//		if( text != null ) {
////			return text.replaceAll(RegexHelper.REGEX_MULTIPLE_SPACE, " ");
//			return text.replaceAll(Pattern.MULTIPLE_SPACE, " ");
//		}
//		return null;
//	}
//	public static String removeSpecialCharacters(String text) {
//		if( text != null ) {
//			return text.replaceAll(Pattern.REMOVE_SPECIAL_CHARACTER, "") ;
//		}
//		return null;
//	}
//	public static String removeSpace(String text) {
//		if( text != null ) {
//			return text.replaceAll(Pattern.SPACE, "");
//		}
//		return null;
//	}
//	public static String removePattern(String pattern, final String originalText) {
//		if( originalText == null ) {
//			return "";
//		}
//		return originalText.replaceAll(pattern, "");
//	}
//}

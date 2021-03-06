package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
public final class Ascii
{
    public static final byte NUL = 0;
    public static final byte SOH = 1;
    public static final byte STX = 2;
    public static final byte ETX = 3;
    public static final byte EOT = 4;
    public static final byte ENQ = 5;
    public static final byte ACK = 6;
    public static final byte BEL = 7;
    public static final byte BS = 8;
    public static final byte HT = 9;
    public static final byte LF = 10;
    public static final byte NL = 10;
    public static final byte VT = 11;
    public static final byte FF = 12;
    public static final byte CR = 13;
    public static final byte SO = 14;
    public static final byte SI = 15;
    public static final byte DLE = 16;
    public static final byte DC1 = 17;
    public static final byte XON = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte XOFF = 19;
    public static final byte DC4 = 20;
    public static final byte NAK = 21;
    public static final byte SYN = 22;
    public static final byte ETB = 23;
    public static final byte CAN = 24;
    public static final byte EM = 25;
    public static final byte SUB = 26;
    public static final byte ESC = 27;
    public static final byte FS = 28;
    public static final byte GS = 29;
    public static final byte RS = 30;
    public static final byte US = 31;
    public static final byte SP = 32;
    public static final byte SPACE = 32;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final char MIN = '\0';
    public static final char MAX = '\u007f';
    
    public static String toLowerCase(final String s) {
        for (int length = s.length(), i = 0; i < length; ++i) {
            if (isUpperCase(s.charAt(i))) {
                final char[] charArray = s.toCharArray();
                while (i < length) {
                    final char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char)(c ^ ' ');
                    }
                    ++i;
                }
                return String.valueOf(charArray);
            }
        }
        return s;
    }
    
    public static String toLowerCase(final CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toLowerCase((String)charSequence);
        }
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append(toLowerCase(charSequence.charAt(i)));
        }
        return sb.toString();
    }
    
    public static char toLowerCase(final char c) {
        return isUpperCase(c) ? ((char)(c ^ ' ')) : c;
    }
    
    public static String toUpperCase(final String s) {
        for (int length = s.length(), i = 0; i < length; ++i) {
            if (isLowerCase(s.charAt(i))) {
                final char[] charArray = s.toCharArray();
                while (i < length) {
                    final char c = charArray[i];
                    if (isLowerCase(c)) {
                        charArray[i] = (char)(c & '_');
                    }
                    ++i;
                }
                return String.valueOf(charArray);
            }
        }
        return s;
    }
    
    public static String toUpperCase(final CharSequence charSequence) {
        if (charSequence instanceof String) {
            return toUpperCase((String)charSequence);
        }
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append(toUpperCase(charSequence.charAt(i)));
        }
        return sb.toString();
    }
    
    public static char toUpperCase(final char c) {
        return isLowerCase(c) ? ((char)(c & '_')) : c;
    }
    
    public static boolean isLowerCase(final char c) {
        return c >= 'a' && c <= 'z';
    }
    
    public static boolean isUpperCase(final char c) {
        return c >= 'A' && c <= 'Z';
    }
    
    @Beta
    public static String truncate(CharSequence charSequence, final int n, final String s) {
        Preconditions.checkNotNull(charSequence);
        final int n2 = n - s.length();
        Preconditions.checkArgument(n2 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", n, s.length());
        if (charSequence.length() <= n) {
            final String string = charSequence.toString();
            if (string.length() <= n) {
                return string;
            }
            charSequence = string;
        }
        return new StringBuilder(n).append(charSequence, 0, n2).append(s).toString();
    }
    
    @Beta
    public static boolean equalsIgnoreCase(final CharSequence charSequence, final CharSequence charSequence2) {
        final int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            final char char2 = charSequence2.charAt(i);
            if (char1 != char2) {
                final int alphaIndex = getAlphaIndex(char1);
                if (alphaIndex >= 26 || alphaIndex != getAlphaIndex(char2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static int getAlphaIndex(final char c) {
        return (char)((c | ' ') - 'a');
    }
}

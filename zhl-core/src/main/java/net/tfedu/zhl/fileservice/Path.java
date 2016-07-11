package net.tfedu.zhl.fileservice;

public class Path {
    public static String GetExtension(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot);
            }
        }
        return "";
    }

    public static String ChangeExtension(String filename, String extension) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(0, dot) + extension;
            }
        }
        return filename;
    }

    public static String GetFileNameWithoutExtension(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('/');
            if (dot < 0)
                dot = filename.lastIndexOf('\\');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                filename = filename.substring(dot + 1);
            }

            dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1)))
                filename = filename.substring(0, dot);
        }
        return filename;
    }

    public static String GetFileName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('\\');
            if (dot < 0)
                dot = filename.lastIndexOf('/');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    public static String GetDirectoryName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('\\');
            if (dot < 0)
                dot = filename.lastIndexOf('/');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
}
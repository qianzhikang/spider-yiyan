package com.qzk.resolve.init;

/**
 * @Description 文件路径常量
 * @Date 2023-06-15-15-45
 * @Author qianzhikang
 */
public enum FilePath {
    /**
     * 常量类型
     */
    ANIME("a", "path/a.json", "动漫"),
    COMIC("b", "path/b.json", "漫画"),
    GAME("c", "path/c.json", "游戏"),
    LITERATURE("d", "path/d.json", "文学"),
    ORIGIN("e", "path/e.json", "原创"),
    INTERNET("f", "path/f.json", "来自网络"),
    OTHER("g", "path/g.json", "其他"),
    MOVIE("h", "path/h.json", "影视"),
    POEM("i", "path/i.json", "诗词"),
    NETEASE("j", "path/j.json", "网易云"),
    PHILOSOPHY("k", "path/k.json", "哲学");
    /**
     * 类型
     */
    private final String type;
    /**
     * 文件路径
     */
    private final String path;
    /**
     * 备注说明
     */
    private final String comment;

    FilePath(String type, String path, String comment) {
        this.type = type;
        this.path = path;
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getComment() {
        return comment;
    }
}

package com.qzk.resolve.init;

/**
 * @Description 请求路径常量
 * @Date 2023-06-15-15-45
 * @Author qianzhikang
 */
public enum HttpPath {
    /**
     * 常量类型
     */
    ANIME("a", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/a.json", "动漫"),
    COMIC("b", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/b.json", "漫画"),
    GAME("c", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/c.json", "游戏"),
    LITERATURE("d", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/d.json", "文学"),
    ORIGIN("e", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/e.json", "原创"),
    INTERNET("f", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/f.json", "来自网络"),
    OTHER("g", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/g.json", "其他"),
    MOVIE("h", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/h.json", "影视"),
    POEM("i", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/i.json", "诗词"),
    NETEASE("j", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/j.json", "网易云"),
    PHILOSOPHY("k", "https://raw.githubusercontent.com/hitokoto-osc/sentences-bundle/master/sentences/k.json", "哲学");
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

    HttpPath(String type, String path, String comment) {
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

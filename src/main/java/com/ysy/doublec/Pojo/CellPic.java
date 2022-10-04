package com.ysy.doublec.Pojo;

import org.springframework.web.multipart.MultipartFile;

public class CellPic {
    private Integer id;
    private MultipartFile cover;
    private String targetName;

    public CellPic() {
    }

    public CellPic(Integer id, MultipartFile cover, String targetName) {
        this.id = id;
        this.cover = cover;
        this.targetName = targetName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }
}

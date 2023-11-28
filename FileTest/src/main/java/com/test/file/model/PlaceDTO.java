package com.test.file.model;

import java.util.List;

import lombok.Data;

@Data
public class PlaceDTO {
	private String seq;
	private String subject;
	private String content;
	private String regdate;

	private List<PicDTO> picList;
	private int picCount;
}

package com.example.weike.entity;

import java.io.Serializable;

/**
 * 
 * @author yanggf
 *
 *������Ӿ硢���ա�������ĳһ����
 *�������̨ĳһ̨��
 *���뱾����Ƶ�б�ĳһ��Ƶ
 */
public class MediaItem implements Serializable{
//	 title: "���Ľ������",
//  url: "http://v.youku.com/v_show/id_XNTI4ODYyNzEy.html",
//  is_play: "1",
//  episode: "1",
//  img_url: "http://t3.baidu.com/it/u=1827644315,2744314791&fm=20",
//  tvid: "0",
//  download: "1",
//  sec: 29019,
//  di: "8a75e669d357d33f"
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2872872605249209107L;

	private String episode;//��ʾ��ǰ�ǵڼ���
	
	private String is_play;//��ʾ��ǰ���ڲ��ŵ��ǵڼ��� 
	
	//���ŵ�ַ������Ҫ�ٶ��ض���
	private String  sourceUrl;
	
	//ֱ�ӿ��Բ��ŵĲ��ŵ�ַ
	private String url;
	
	//ӰƬ���ơ���̨���ơ�������Ƶ����
	private String title;
	
	//�Ƿ��ǵ���ֱ̨��
	private boolean isLive = false;
	
	private int flags;
	
	private String image;
	
	//�ļ���С
	private float fileSize;
	
	
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public float getFileSize() {
		return fileSize;
	}
	public void setFileSize(float fileSize) {
		this.fileSize = fileSize;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	public String getEpisode() {
		return episode;
	}
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	public String getIs_play() {
		return is_play;
	}
	public void setIs_play(String is_play) {
		this.is_play = is_play;
	}

	
}

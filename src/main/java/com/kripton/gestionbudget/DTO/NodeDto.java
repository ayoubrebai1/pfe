package com.kripton.gestionbudget.DTO;



import com.kripton.gestionbudget.entities.Shape;
import com.kripton.gestionbudget.entities.Style;
public class NodeDto {

	private Integer id;
	private Shape shape;
	private Integer height;
	private Integer width;
	private Style style;
	private Integer offsetX;
	private Integer offsetY;
	private OrganigrammeDto organigramme;
	
	
	public OrganigrammeDto getOrganigramme() {
		return organigramme;
	}
	public void setOrganigramme(OrganigrammeDto organigramme) {
		this.organigramme = organigramme;
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public Integer getOffsetX() {
		return offsetX;
	}
	public void setOffsetX(Integer offsetX) {
		this.offsetX = offsetX;
	}
	public Integer getOffsetY() {
		return offsetY;
	}
	public void setOffsetY(Integer offsetY) {
		this.offsetY = offsetY;
	}
}

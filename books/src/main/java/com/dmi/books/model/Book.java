package com.dmi.books.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="BOOK")
@SequenceGenerator(name="SQ_BOOK", sequenceName="SQ_BOOK")
public class Book {

	/**
	 * The unique identifier of the item
	 */
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE, generator = "SQ_BOOK")
	@Column(name = "B_ID")
	private Long id;
	
	/**
	 * The URL to the item cover-art
	 */
	@NotNull
	@Column(name = "B_IMAGE", length=100)
	private String image;
	
	/**
	 * The title of the item
	 */
	@NotNull
	@Column(name = "B_TITLE", length = 4000)
	private String title;
	
	/**
	 * The author of the item
	 */
	@NotNull
	@Column(name = "B_AUTHOR", length=100)
	private String author;
	
	/**
	 * The price of the item
	 */
	@NotNull
	@Column(name = "B_PRICE", length=8, scale=2)
	private BigDecimal price;
	
	/**
	 * The version of the item
	 */
	@NotNull
	@Version
	@Column(name = "B_VERSION", length=8)
	private Integer version;
	
	/**
	 * The path to the item details
	 */
	@Transient
	private String link;
	
	public Book() {

	}

	public Book(Long id, String image, String title, String author, BigDecimal price ) {
		this.id = id;
		this.image = image;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * the link with a 
	 * @return
	 */
	public String getLink() {
		
		if(getId() != null){
		
			StringBuilder sb = new StringBuilder();
			sb.append("/api");
			sb.append("/v1");
			sb.append("/items/");
			sb.append(getId());
			
			return sb.toString();
		}
		
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}

package dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.servlet.annotation.MultipartConfig;

import lombok.Data;

@Entity
@Data
@MultipartConfig
public class Fooditem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String type;
	@Lob
	private byte[] picture;
}
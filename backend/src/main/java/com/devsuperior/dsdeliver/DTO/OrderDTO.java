package com.devsuperior.dsdeliver.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	private Double total;

	private List<ProductDTO> products = new ArrayList<>();

	public OrderDTO() {

	}

	public OrderDTO(Long id, String address, Double latitude, 
			Double longitude, Instant moment, OrderStatus status, Double total) {
		super();
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		this.total = total;
	}
	
	public OrderDTO(Order entity) {
		id = entity.getId();
		address = entity.getAddress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		total = entity.getTotal();
		products = entity.getProducts().parallelStream()
				.map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}	

	
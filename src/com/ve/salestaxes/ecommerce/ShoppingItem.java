package com.ve.salestaxes.ecommerce;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.ve.salestaxes.goods.Item;

/**
 * 
 * @author Valerio Emanuele
 * @see Item
 * This class describe an item that can be added to Shopping Basket.
 * It wraps an Item and add a quantity field to take count 
 * of the numbers of the same items placed in the shopping basket.
 */
public class ShoppingItem
{
	private static final transient Logger log = Logger.getLogger(ShoppingItem.class);
	private Item item;
	private int quantity;
	
	public ShoppingItem(Item item, int quantity)
	{
		super();
		this.item = item;
		this.quantity = quantity;
	}
	
	public ShoppingItem(Item item)
	{
		this(item, 1);
	}

	public int getKey(){
		return item.hashCode();
	}
	
	public Item getItem()
	{
		return item;
	}
	
	public BigDecimal getShelfPrice(){
		return item.getShelfPrice().multiply(new BigDecimal(quantity));
	}
	
	public BigDecimal getSalesTax(){
		return item.getSalesTaxAmount().multiply(new BigDecimal(quantity));
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		//the quantity can't be < 1
		if (quantity < 1){
			String message = "quantity can't be less than 1";
			log.error(message);
			throw new IllegalArgumentException(message);
		}
		this.quantity = quantity;
	}
	
}
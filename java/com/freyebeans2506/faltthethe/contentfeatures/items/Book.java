package com.freyebeans2506.faltthethe.contentfeatures.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Book extends Item {
    public Book(Properties properties) {
        super(properties);
    }
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        final ItemStack bookself = itemStack.copy();
        return bookself;
    }

}

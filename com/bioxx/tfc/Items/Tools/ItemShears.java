/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemShears
/*     */   extends ItemTerraTool
/*     */ {
/*     */   public ItemShears(float dam, Item.ToolMaterial par3) {
/*  31 */     super(dam, par3, Sets.newHashSet((Object[])new Block[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  37 */     this.field_77791_bV = registerer.func_94245_a("minecraft:" + func_77658_a().replace("item.", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  43 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  49 */     return EnumWeight.LIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_150894_a(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
/*  55 */     if (block.func_149688_o() != Material.field_151584_j && block != Blocks.field_150321_G && block != Blocks.field_150329_H && block != Blocks.field_150395_bd && block != Blocks.field_150473_bD && !(block instanceof IShearable))
/*     */     {
/*  57 */       return super.func_150894_a(is, world, block, x, y, z, entity);
/*     */     }
/*     */ 
/*     */     
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_150897_b(Block block) {
/*  68 */     return (block == Blocks.field_150321_G || block == Blocks.field_150488_af || block == Blocks.field_150473_bD);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_150893_a(ItemStack is, Block block) {
/*  74 */     return (block != Blocks.field_150321_G && block.func_149688_o() != Material.field_151584_j) ? ((block == Blocks.field_150325_L) ? 5.0F : super.func_150893_a(is, block)) : 15.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity) {
/*  83 */     if (entity.field_70170_p.field_72995_K)
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     if (entity instanceof IShearable) {
/*     */       
/*  89 */       IShearable target = (IShearable)entity;
/*  90 */       if (target.isShearable(itemstack, (IBlockAccess)entity.field_70170_p, (int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v)) {
/*     */         
/*  92 */         ArrayList<ItemStack> drops = target.onSheared(itemstack, (IBlockAccess)entity.field_70170_p, (int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v, 
/*  93 */             EnchantmentHelper.func_77506_a(Enchantment.field_77346_s.field_77352_x, itemstack));
/*     */         
/*  95 */         Random rand = new Random();
/*  96 */         for (ItemStack stack : drops) {
/*     */           
/*  98 */           EntityItem ent = entity.func_70099_a(stack, 1.0F);
/*  99 */           ent.field_70181_x += (rand.nextFloat() * 0.05F);
/* 100 */           ent.field_70159_w += ((rand.nextFloat() - rand.nextFloat()) * 0.1F);
/* 101 */           ent.field_70179_y += ((rand.nextFloat() - rand.nextFloat()) * 0.1F);
/*     */         } 
/* 103 */         itemstack.func_77972_a(1, entity);
/*     */       } 
/* 105 */       return true;
/*     */     } 
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
/* 113 */     if (player.field_70170_p.field_72995_K)
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     Block block = player.field_70170_p.func_147439_a(x, y, z);
/* 118 */     if (block instanceof IShearable) {
/*     */       
/* 120 */       IShearable target = (IShearable)block;
/* 121 */       if (target.isShearable(itemstack, (IBlockAccess)player.field_70170_p, x, y, z)) {
/*     */         
/* 123 */         ArrayList<ItemStack> drops = target.onSheared(itemstack, (IBlockAccess)player.field_70170_p, x, y, z, 
/* 124 */             EnchantmentHelper.func_77506_a(Enchantment.field_77346_s.field_77352_x, itemstack));
/* 125 */         Random rand = new Random();
/*     */         
/* 127 */         for (ItemStack stack : drops) {
/*     */           
/* 129 */           float f = 0.7F;
/* 130 */           double d = (rand.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 131 */           double d1 = (rand.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 132 */           double d2 = (rand.nextFloat() * f) + (1.0F - f) * 0.5D;
/* 133 */           EntityItem entityitem = new EntityItem(player.field_70170_p, x + d, y + d1, z + d2, stack);
/* 134 */           entityitem.field_145804_b = 10;
/* 135 */           player.field_70170_p.func_72838_d((Entity)entityitem);
/*     */         } 
/*     */         
/* 138 */         itemstack.func_77972_a(1, (EntityLivingBase)player);
/* 139 */         player.func_71064_a(StatList.field_75934_C[Block.func_149682_b(block)], 1);
/*     */       } 
/*     */     } 
/* 142 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemShears.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
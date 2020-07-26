/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLeashKnot;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemLead;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomLeash
/*     */   extends ItemLead
/*     */   implements ISize
/*     */ {
/*  30 */   public String textureFolder = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  39 */     Block b = par3World.func_147439_a(par4, par5, par6);
/*  40 */     if (TFCBlocks.isBlockAFence(b)) {
/*     */       
/*  42 */       if (par3World.field_72995_K)
/*     */       {
/*  44 */         return true;
/*     */       }
/*     */ 
/*     */       
/*  48 */       tryLeash(par2EntityPlayer, par3World, par4, par5, par6);
/*  49 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean tryLeash(EntityPlayer par0EntityPlayer, World par1World, int par2, int par3, int par4) {
/*  60 */     EntityLeashKnot entityleashknot = EntityLeashKnot.func_110130_b(par1World, par2, par3, par4);
/*  61 */     boolean flag = false;
/*  62 */     double d0 = 7.0D;
/*  63 */     List list = par1World.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72330_a(par2 - d0, par3 - d0, par4 - d0, par2 + d0, par3 + d0, par4 + d0));
/*     */     
/*  65 */     if (list != null) {
/*     */       
/*  67 */       Iterator<EntityLiving> iterator = list.iterator();
/*  68 */       while (iterator.hasNext()) {
/*     */         
/*  70 */         EntityLiving entityliving = iterator.next();
/*  71 */         if (entityliving.func_110167_bD() && entityliving.func_110166_bE() == par0EntityPlayer) {
/*     */           
/*  73 */           if (entityleashknot == null)
/*  74 */             entityleashknot = EntityLeashKnot.func_110129_a(par1World, par2, par3, par4); 
/*  75 */           entityliving.func_110162_b((Entity)entityleashknot, true);
/*  76 */           flag = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*  80 */     return flag;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_77617_a(int meta) {
/*  86 */     return this.field_77791_bV;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  93 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  99 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 105 */     return EnumSize.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/* 111 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 117 */     return EnumItemReach.FAR;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 123 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemCustomLeash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
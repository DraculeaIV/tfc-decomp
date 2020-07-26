/*    */ package com.bioxx.tfc.Items;
/*    */ 
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemFlatGeneric
/*    */   extends ItemTerra
/*    */ {
/*    */   public IIcon[] icons;
/*    */   
/*    */   public ItemFlatGeneric() {
/* 18 */     this.field_77787_bX = false;
/* 19 */     func_77656_e(0);
/* 20 */     this.field_77777_bU = 25;
/* 21 */     func_77637_a(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemFlatGeneric(int id, String tex) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77663_a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
/* 33 */     ((EntityPlayer)par3Entity).field_71071_by.func_70299_a(par4, null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 45 */     if (this.metaNames == null) {
/* 46 */       this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + func_77658_a().replace("item.", ""));
/*    */     } else {
/*    */       
/* 49 */       this.icons = new IIcon[this.metaNames.length];
/* 50 */       for (int i = 0; i < this.metaNames.length; i++)
/*    */       {
/* 52 */         this.icons[i] = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + this.metaNames[i]);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_77617_a(int damage) {
/* 60 */     if (this.metaNames == null) {
/* 61 */       return this.field_77791_bV;
/*    */     }
/* 63 */     return this.icons[damage];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemFlatGeneric.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
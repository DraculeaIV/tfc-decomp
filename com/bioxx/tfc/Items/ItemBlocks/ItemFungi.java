/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemFungi
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   public ItemFungi(Block b) {
/* 21 */     super(b);
/* 22 */     this.metaNames = Global.FUNGI_META_NAMES;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int par1) {
/* 29 */     return TFCBlocks.fungi.func_149691_a(0, par1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 38 */     MovingObjectPosition movingobjectposition = func_77621_a(par2World, par3EntityPlayer, true);
/*    */     
/* 40 */     if (movingobjectposition == null)
/*    */     {
/* 42 */       return par1ItemStack;
/*    */     }
/*    */ 
/*    */     
/* 46 */     if (movingobjectposition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*    */       
/* 48 */       int i = movingobjectposition.field_72311_b;
/* 49 */       int j = movingobjectposition.field_72312_c;
/* 50 */       int k = movingobjectposition.field_72309_d;
/*    */       
/* 52 */       if (!par2World.func_72962_a(par3EntityPlayer, i, j, k)) {
/* 53 */         return par1ItemStack;
/*    */       }
/* 55 */       if (!par3EntityPlayer.func_82247_a(i, j, k, movingobjectposition.field_72310_e, par1ItemStack)) {
/* 56 */         return par1ItemStack;
/*    */       }
/* 58 */       if (TFCBlocks.fungi.func_149718_j(par2World, i, j + 1, k) && par2World.func_147437_c(i, j + 1, k)) {
/*    */         
/* 60 */         par2World.func_147465_d(i, j + 1, k, TFCBlocks.fungi, par1ItemStack.func_77960_j(), 3);
/* 61 */         par2World.func_72908_a((i + 0.5F), (j + 0.5F), (k + 0.5F), TFCBlocks.fungi.field_149762_H.func_150496_b(), (TFCBlocks.fungi.field_149762_H.func_150497_c() + 1.0F) / 2.0F, TFCBlocks.fungi.field_149762_H.func_150494_d() * 0.8F);
/* 62 */         if (!par3EntityPlayer.field_71075_bZ.field_75098_d) par1ItemStack.field_77994_a--; 
/*    */       } 
/*    */     } 
/* 65 */     return par1ItemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemFungi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package com.bioxx.tfc.Items.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSteelBucketRed
/*    */   extends ItemSteelBucket
/*    */ {
/*    */   public ItemSteelBucketRed(Block par2) {
/* 18 */     super(par2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 24 */     String name = func_77658_a().replace("item.", "");
/* 25 */     name = name.replace("Salt ", "");
/* 26 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:" + this.textureFolder + name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 32 */     if (this.bucketContents != Blocks.field_150350_a && world.func_147439_a(x, y, z) == Blocks.field_150383_bp) {
/*    */       
/* 34 */       int meta = world.func_72805_g(x, y, z);
/* 35 */       if (meta < 3) {
/*    */         
/* 37 */         if (!player.field_71075_bZ.field_75098_d)
/*    */         {
/* 39 */           player.func_70062_b(0, new ItemStack(TFCItems.redSteelBucketEmpty));
/*    */         }
/* 41 */         world.func_72921_c(x, y, z, MathHelper.func_76125_a(3, 0, 3), 2);
/* 42 */         world.func_147453_f(x, y, z, (Block)Blocks.field_150383_bp);
/*    */         
/* 44 */         return true;
/*    */       } 
/*    */     } 
/*    */     
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemSteelBucketRed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
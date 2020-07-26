/*    */ package com.bioxx.tfc.Items.ItemBlocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSoil
/*    */   extends ItemTerraBlock
/*    */ {
/*    */   private IIcon icon;
/*    */   
/*    */   public ItemSoil(Block b) {
/* 26 */     super(b);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 33 */     super.func_77624_a(is, player, arraylist, flag);
/*    */     
/* 35 */     Block b = Block.func_149634_a(is.func_77973_b());
/* 36 */     if (TFC_Core.isPeat(b) || TFC_Core.isPeatGrass(b)) {
/*    */       return;
/*    */     }
/* 39 */     int dam = is.func_77960_j();
/* 40 */     if (b == TFCBlocks.dirt2 || b == TFCBlocks.sand2 || b == TFCBlocks.clay2 || 
/*    */ 
/*    */       
/* 43 */       TFC_Core.isGrassType2(b) || b == TFCBlocks.tilledSoil2 || b == TFCBlocks.gravel2)
/*    */     {
/*    */ 
/*    */       
/* 47 */       dam += 16;
/*    */     }
/*    */     
/* 50 */     if (dam < Global.STONE_ALL.length) {
/* 51 */       arraylist.add(EnumChatFormatting.DARK_GRAY + Global.STONE_ALL[dam]);
/*    */     } else {
/* 53 */       arraylist.add(EnumChatFormatting.DARK_RED + "Unknown");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 59 */     if (this.field_150939_a instanceof com.bioxx.tfc.Blocks.Terrain.BlockPeat) {
/*    */       
/* 61 */       String s = this.field_150939_a.func_149702_O();
/*    */       
/* 63 */       if (s != null)
/*    */       {
/* 65 */         this.icon = registerer.func_94245_a(s);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int damage) {
/* 78 */     if (this.field_150939_a instanceof com.bioxx.tfc.Blocks.Terrain.BlockPeat)
/*    */     {
/* 80 */       return (this.icon != null) ? this.icon : this.field_150939_a.func_149733_h(1);
/*    */     }
/*    */     
/* 83 */     return super.func_77617_a(damage);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemSoil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
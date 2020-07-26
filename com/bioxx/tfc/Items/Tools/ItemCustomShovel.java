/*    */ package com.bioxx.tfc.Items.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemCustomShovel
/*    */   extends ItemTerraTool
/*    */ {
/* 18 */   private static final Set<Block> BLOCKS_EFFECTIVE_AGAINST = Sets.newHashSet((Object[])new Block[] { (Block)Blocks.field_150349_c, Blocks.field_150346_d, (Block)Blocks.field_150354_m, Blocks.field_150351_n, Blocks.field_150433_aE, Blocks.field_150431_aC, Blocks.field_150435_aG, Blocks.field_150458_ak, Blocks.field_150425_aM, (Block)Blocks.field_150391_bh, TFCBlocks.dirt, TFCBlocks.dirt2, TFCBlocks.grass, TFCBlocks.grass2, TFCBlocks.clayGrass, TFCBlocks.clayGrass2, TFCBlocks.peatGrass, TFCBlocks.peat, TFCBlocks.clay, TFCBlocks.clay2 });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemCustomShovel(Item.ToolMaterial par2EnumToolMaterial) {
/* 28 */     super(1.0F, par2EnumToolMaterial, BLOCKS_EFFECTIVE_AGAINST);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_150897_b(Block par1Block) {
/* 37 */     return (par1Block == Blocks.field_150431_aC) ? true : ((par1Block == Blocks.field_150433_aE));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister registerer) {
/* 43 */     String name = func_77658_a().replace("item.", "");
/* 44 */     name = name.replace("IgIn ", "");
/* 45 */     name = name.replace("IgEx ", "");
/* 46 */     name = name.replace("Sed ", "");
/* 47 */     name = name.replace("MM ", "");
/* 48 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumItemReach getReach(ItemStack is) {
/* 54 */     return EnumItemReach.FAR;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomShovel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
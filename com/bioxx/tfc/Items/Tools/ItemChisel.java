/*    */ package com.bioxx.tfc.Items.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*    */ import com.bioxx.tfc.api.Enums.EnumSize;
/*    */ import com.bioxx.tfc.api.Tools.ChiselManager;
/*    */ import com.bioxx.tfc.api.Tools.IToolChisel;
/*    */ import com.google.common.collect.HashMultimap;
/*    */ import com.google.common.collect.Multimap;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemChisel
/*    */   extends ItemTerraTool
/*    */   implements IToolChisel {
/* 22 */   private static final Set<Block> BLOCKS = Sets.newHashSet((Object[])new Block[0]);
/*    */ 
/*    */   
/*    */   public ItemChisel(Item.ToolMaterial e) {
/* 26 */     super(0.0F, e, BLOCKS);
/* 27 */     func_77656_e(e.func_77997_a() / 2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumSize getSize(ItemStack is) {
/* 33 */     return EnumSize.VERYSMALL;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist) {
/* 39 */     if (TFC_Core.showShiftInformation()) {
/*    */       
/* 41 */       arraylist.add(TFC_Core.translate("gui.Help"));
/* 42 */       arraylist.add(TFC_Core.translate("gui.Chisel.Inst0"));
/*    */     }
/*    */     else {
/*    */       
/* 46 */       arraylist.add(TFC_Core.translate("gui.ShowHelp"));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onUsed(World world, EntityPlayer player, int x, int y, int z, Block block, int meta, int side, float hitX, float hitY, float hitZ) {
/* 53 */     return ChiselManager.getInstance().onUsedHandler(world, player, x, y, z, block, meta, side, hitX, hitY, hitZ);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canChisel(EntityPlayer player, int x, int y, int z) {
/* 59 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Multimap func_111205_h() {
/* 65 */     return (Multimap)HashMultimap.create();
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumItemReach getReach(ItemStack is) {
/* 70 */     return EnumItemReach.SHORT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemChisel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
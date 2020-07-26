/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Food.CropIndex;
/*     */ import com.bioxx.tfc.Food.CropManager;
/*     */ import com.bioxx.tfc.TileEntities.TECrop;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomSeeds
/*     */   extends ItemTerra
/*     */ {
/*     */   private int cropId;
/*     */   
/*     */   public ItemCustomSeeds(int cropId) {
/*  34 */     this.cropId = cropId;
/*  35 */     func_77637_a(TFCTabs.TFC_FOODS);
/*  36 */     setFolder("food/");
/*  37 */     setWeight(EnumWeight.LIGHT);
/*  38 */     setSize(EnumSize.TINY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  48 */     if (side != 1 || world.field_72995_K)
/*  49 */       return false; 
/*  50 */     if (player.func_82247_a(x, y, z, side, stack) && player.func_82247_a(x, y + 1, z, side, stack)) {
/*     */       
/*  52 */       Block var8 = world.func_147439_a(x, y, z);
/*  53 */       if ((var8 == TFCBlocks.tilledSoil || var8 == TFCBlocks.tilledSoil2) && world.func_147437_c(x, y + 1, z)) {
/*     */         
/*  55 */         CropIndex crop = CropManager.getInstance().getCropFromId(this.cropId);
/*  56 */         if (crop.needsSunlight && !TECrop.hasSunlight(world, x, y + 1, z)) {
/*     */           
/*  58 */           TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("gui.seeds.failedSun", new Object[0]));
/*  59 */           return false;
/*     */         } 
/*     */         
/*  62 */         if (TFC_Climate.getHeightAdjustedTemp(world, x, y, z) <= crop.minAliveTemp && !crop.dormantInFrost) {
/*     */           
/*  64 */           TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("gui.seeds.failedTemp", new Object[0]));
/*  65 */           return false;
/*     */         } 
/*     */         
/*  68 */         world.func_147449_b(x, y + 1, z, TFCBlocks.crops);
/*     */         
/*  70 */         TECrop te = (TECrop)world.func_147438_o(x, y + 1, z);
/*  71 */         te.cropId = this.cropId;
/*  72 */         world.func_147471_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*  73 */         world.func_147471_g(x, y, z);
/*  74 */         stack.field_77994_a--;
/*  75 */         return true;
/*     */       } 
/*     */       
/*  78 */       return false;
/*     */     } 
/*     */     
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  87 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */     
/*  89 */     SkillStats.SkillRank rank = TFC_Core.getSkillStats(player).getSkillRank("skill.agriculture");
/*  90 */     int nutrient = CropManager.getInstance().getCropFromId(this.cropId).getCycleType();
/*     */     
/*  92 */     if (rank == SkillStats.SkillRank.Expert || rank == SkillStats.SkillRank.Master)
/*     */     {
/*  94 */       switch (nutrient) {
/*     */         
/*     */         case 0:
/*  97 */           arraylist.add(EnumChatFormatting.RED + TFC_Core.translate("gui.Nutrient.A"));
/*     */           break;
/*     */         case 1:
/* 100 */           arraylist.add(EnumChatFormatting.GOLD + TFC_Core.translate("gui.Nutrient.B"));
/*     */           break;
/*     */         case 2:
/* 103 */           arraylist.add(EnumChatFormatting.YELLOW + TFC_Core.translate("gui.Nutrient.C"));
/*     */           break;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemCustomSeeds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
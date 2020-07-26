/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ import com.bioxx.tfc.Blocks.Terrain.BlockOre;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.TileEntities.TEOre;
/*     */ import com.bioxx.tfc.WorldGen.Generators.OreSpawnData;
/*     */ import com.bioxx.tfc.WorldGen.Generators.WorldGenOre;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ public class ItemProPick extends ItemTerra {
/*  36 */   private Map<String, ProspectResult> results = new HashMap<String, ProspectResult>();
/*     */   
/*     */   private Random random;
/*     */ 
/*     */   
/*     */   public ItemProPick() {
/*  42 */     this.field_77777_bU = 1;
/*  43 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  44 */     setWeight(EnumWeight.LIGHT);
/*  45 */     setSize(EnumSize.SMALL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  51 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + func_77658_a().replace("item.", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/*  57 */     NBTTagCompound nbt = stack.func_77978_p();
/*  58 */     if (pass == 1 && nbt != null && nbt.func_74764_b("broken")) {
/*  59 */       return TFC_Textures.brokenItem;
/*     */     }
/*  61 */     return func_77618_c(stack.func_77960_j(), pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  67 */     Block block = world.func_147439_a(x, y, z);
/*  68 */     if (!world.field_72995_K) {
/*     */ 
/*     */       
/*  71 */       if (block == TFCBlocks.toolRack) {
/*  72 */         return true;
/*     */       }
/*     */       
/*  75 */       int meta = world.func_72805_g(x, y, z);
/*     */       
/*  77 */       SkillStats.SkillRank rank = TFC_Core.getSkillStats(player).getSkillRank("skill.prospecting");
/*     */ 
/*     */       
/*  80 */       if ((block == TFCBlocks.ore || block == TFCBlocks.ore2 || block == TFCBlocks.ore3) && world
/*  81 */         .func_147438_o(x, y, z) instanceof TEOre) {
/*     */         
/*  83 */         TEOre te = (TEOre)world.func_147438_o(x, y, z);
/*  84 */         if (block == TFCBlocks.ore && rank == SkillStats.SkillRank.Master)
/*  85 */           meta = ((BlockOre)block).getOreGrade(te, meta); 
/*  86 */         if (block == TFCBlocks.ore2) meta += Global.ORE_METAL.length; 
/*  87 */         if (block == TFCBlocks.ore3) meta = meta + Global.ORE_METAL.length + Global.ORE_MINERAL.length; 
/*  88 */         tellResult(player, new ItemStack(TFCItems.oreChunk, 1, meta));
/*  89 */         return true;
/*     */       } 
/*  91 */       if (!TFC_Core.isGround(block)) {
/*     */         
/*  93 */         Iterator<OreSpawnData> iter = WorldGenOre.oreList.values().iterator();
/*  94 */         while (iter.hasNext()) {
/*     */           
/*  96 */           OreSpawnData osd = iter.next();
/*  97 */           if (osd != null && block == osd.block) {
/*     */             
/*  99 */             tellResult(player, new ItemStack(block));
/* 100 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 105 */       this.random = new Random((x * z + y));
/* 106 */       int chance = 60 + (rank.ordinal() + 1) * 10;
/*     */       
/* 108 */       this.results.clear();
/*     */ 
/*     */       
/* 111 */       if (this.random.nextInt(100) >= chance && rank != SkillStats.SkillRank.Master) {
/*     */         
/* 113 */         tellNothingFound(player);
/* 114 */         return true;
/*     */       } 
/*     */       
/* 117 */       this.results.clear();
/*     */ 
/*     */       
/* 120 */       for (int i = -12; i < 12; i++) {
/*     */         
/* 122 */         for (int j = -12; j < 12; j++) {
/*     */           
/* 124 */           for (int k = -12; k < 12; k++) {
/*     */             
/* 126 */             int blockX = x + i;
/* 127 */             int blockY = y + j;
/* 128 */             int blockZ = z + k;
/*     */             
/* 130 */             block = world.func_147439_a(blockX, blockY, blockZ);
/* 131 */             meta = world.func_72805_g(blockX, blockY, blockZ);
/* 132 */             ItemStack ore = null;
/* 133 */             if (block == TFCBlocks.ore && world.func_147438_o(blockX, blockY, blockZ) instanceof TEOre) {
/*     */               
/* 135 */               TEOre te = (TEOre)world.func_147438_o(blockX, blockY, blockZ);
/* 136 */               if (rank == SkillStats.SkillRank.Master) {
/* 137 */                 ore = new ItemStack(TFCItems.oreChunk, 1, ((BlockOre)block).getOreGrade(te, meta));
/*     */               } else {
/* 139 */                 ore = new ItemStack(TFCItems.oreChunk, 1, meta);
/*     */               } 
/* 141 */             } else if (block == TFCBlocks.ore2) {
/* 142 */               ore = new ItemStack(TFCItems.oreChunk, 1, meta + Global.ORE_METAL.length);
/* 143 */             } else if (block == TFCBlocks.ore3) {
/* 144 */               ore = new ItemStack(TFCItems.oreChunk, 1, meta + Global.ORE_METAL.length + Global.ORE_MINERAL.length);
/* 145 */             } else if (!TFC_Core.isGround(block)) {
/*     */               
/* 147 */               Iterator<OreSpawnData> iter = WorldGenOre.oreList.values().iterator();
/* 148 */               while (iter.hasNext()) {
/*     */                 
/* 150 */                 OreSpawnData osd = iter.next();
/* 151 */                 if (osd != null && block == osd.block) {
/*     */                   
/* 153 */                   ore = new ItemStack(block);
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } else {
/*     */               continue;
/*     */             } 
/* 161 */             if (ore != null) {
/*     */               
/* 163 */               String oreName = ore.func_82833_r();
/*     */               
/* 165 */               if (this.results.containsKey(oreName)) {
/* 166 */                 ((ProspectResult)this.results.get(oreName)).count++;
/*     */               } else {
/* 168 */                 this.results.put(oreName, new ProspectResult(ore, 1));
/*     */               } 
/* 170 */               ore = null;
/* 171 */               oreName = null;
/*     */             } 
/*     */             
/*     */             continue;
/*     */           } 
/*     */         } 
/*     */       } 
/* 178 */       if (this.results.isEmpty()) {
/* 179 */         tellNothingFound(player);
/*     */       } else {
/* 181 */         tellResult(player);
/*     */       } 
/*     */       
/* 184 */       this.results.clear();
/* 185 */       this.random = null;
/*     */ 
/*     */       
/* 188 */       itemStack.func_77972_a(1, (EntityLivingBase)player);
/* 189 */       if (itemStack.func_77960_j() >= itemStack.func_77958_k()) {
/* 190 */         player.func_71028_bD();
/*     */       }
/*     */     } 
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void tellNothingFound(EntityPlayer player) {
/* 201 */     TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("gui.ProPick.FoundNothing", new Object[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void tellResult(EntityPlayer player, ItemStack ore) {
/* 209 */     String oreName = ore.func_77977_a() + ".name";
/* 210 */     TFC_Core.sendInfoMessage(player, (new ChatComponentTranslation("gui.ProPick.Found", new Object[0]))
/*     */         
/* 212 */         .func_150258_a(" ")
/* 213 */         .func_150257_a((IChatComponent)new ChatComponentTranslation(oreName, new Object[0])));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void tellResult(EntityPlayer player) {
/*     */     String quantityMsg;
/* 222 */     TFC_Core.getSkillStats(player).increaseSkill("skill.prospecting", 1);
/* 223 */     int index = this.random.nextInt(this.results.size());
/* 224 */     ProspectResult result = ((ProspectResult[])this.results.values().toArray((T[])new ProspectResult[0]))[index];
/* 225 */     String oreName = result.itemStack.func_77977_a() + ".name";
/*     */ 
/*     */     
/* 228 */     if (result.count < 10) {
/* 229 */       quantityMsg = "gui.ProPick.FoundTraces";
/* 230 */     } else if (result.count < 20) {
/* 231 */       quantityMsg = "gui.ProPick.FoundSmall";
/* 232 */     } else if (result.count < 40) {
/* 233 */       quantityMsg = "gui.ProPick.FoundMedium";
/* 234 */     } else if (result.count < 80) {
/* 235 */       quantityMsg = "gui.ProPick.FoundLarge";
/*     */     } else {
/* 237 */       quantityMsg = "gui.ProPick.FoundVeryLarge";
/*     */     } 
/* 239 */     TFC_Core.sendInfoMessage(player, (new ChatComponentTranslation(quantityMsg, new Object[0]))
/*     */         
/* 241 */         .func_150258_a(" ")
/* 242 */         .func_150257_a((IChatComponent)new ChatComponentTranslation(oreName, new Object[0])));
/*     */     
/* 244 */     oreName = null;
/* 245 */     result = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 251 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private class ProspectResult
/*     */   {
/*     */     public ItemStack itemStack;
/*     */     public int count;
/*     */     
/*     */     public ProspectResult(ItemStack itemStack, int count) {
/* 261 */       this.itemStack = itemStack;
/* 262 */       this.count = count;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 269 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack stack) {
/* 275 */     return (int)(func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(stack));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDigSpeed(ItemStack stack, Block block, int meta) {
/* 281 */     float digSpeed = super.getDigSpeed(stack, block, meta);
/*     */     
/* 283 */     if (ForgeHooks.isToolEffective(stack, block, meta))
/*     */     {
/* 285 */       return digSpeed + digSpeed * AnvilManager.getDurabilityBuff(stack);
/*     */     }
/* 287 */     return digSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 293 */     ItemTerra.addSizeInformation(is, arraylist);
/* 294 */     ItemTerraTool.addSmithingBonusInformation(is, arraylist);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemProPick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
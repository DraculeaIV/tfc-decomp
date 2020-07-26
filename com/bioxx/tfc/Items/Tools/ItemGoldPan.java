/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Chunkdata.ChunkData;
/*     */ import com.bioxx.tfc.Core.Player.SkillStats;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemGoldPan
/*     */   extends ItemTerra
/*     */ {
/*  32 */   public static String[] metaNames = new String[] { "", "Sand", "Gravel", "Clay", "Dirt" };
/*  33 */   public IIcon[] icons = new IIcon[metaNames.length];
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemGoldPan() {
/*  39 */     func_77656_e(0);
/*  40 */     func_77627_a(true);
/*  41 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  47 */     return EnumSize.SMALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/*  53 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_77617_a(int i) {
/*  65 */     i &= 0xF;
/*  66 */     if (i == 1)
/*  67 */       return this.icons[1]; 
/*  68 */     if (i == 2)
/*  69 */       return this.icons[2]; 
/*  70 */     if (i == 3)
/*  71 */       return this.icons[3]; 
/*  72 */     if (i == 4)
/*  73 */       return this.icons[4]; 
/*  74 */     return this.icons[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  80 */     this.icons[0] = registerer.func_94245_a("terrafirmacraft:tools/GoldPan_0");
/*  81 */     this.icons[1] = registerer.func_94245_a("terrafirmacraft:tools/GoldPan_1");
/*  82 */     this.icons[2] = registerer.func_94245_a("terrafirmacraft:tools/GoldPan_2");
/*  83 */     this.icons[3] = registerer.func_94245_a("terrafirmacraft:tools/GoldPan_3");
/*  84 */     this.icons[4] = registerer.func_94245_a("terrafirmacraft:tools/GoldPan_4");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/*  90 */     if (world.field_72995_K) {
/*  91 */       return is;
/*     */     }
/*     */     
/*  94 */     MovingObjectPosition mop = func_77621_a(world, player, true);
/*     */     
/*  96 */     if (mop == null)
/*     */     {
/*  98 */       return is;
/*     */     }
/*     */ 
/*     */     
/* 102 */     int x = mop.field_72311_b;
/* 103 */     int y = mop.field_72312_c;
/* 104 */     int z = mop.field_72309_d;
/* 105 */     Block blockHit = world.func_147439_a(x, y, z);
/* 106 */     if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK)
/*     */     {
/* 108 */       if (is.func_77960_j() == 0) {
/*     */ 
/*     */         
/* 111 */         if (world.func_147439_a(x, y + 1, z).func_149688_o() == Material.field_151586_h)
/*     */         {
/* 113 */           return is;
/*     */         }
/*     */         
/* 116 */         ChunkData cd = TFC_Core.getCDM(world).getData(x >> 4, z >> 4);
/*     */ 
/*     */         
/* 119 */         if (cd == null) {
/*     */           
/* 121 */           TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentText("The ChunkData returned null, please report this to the developer."));
/* 122 */           return is;
/*     */         } 
/*     */ 
/*     */         
/* 126 */         if (cd.sluicedAmount < TFCOptions.goldPanLimit || !TFCOptions.enableOverworkingChunks) {
/*     */           
/* 128 */           if (TFC_Core.isGravel(blockHit))
/*     */           {
/* 130 */             is.func_77964_b(82);
/* 131 */             if (world.field_73012_v.nextInt(10) == 0)
/* 132 */               world.func_147468_f(x, y, z); 
/* 133 */             TFC_Core.addPlayerExhaustion(player, 5.0E-4F);
/* 134 */             cd.sluicedAmount++;
/*     */           }
/* 136 */           else if (TFC_Core.isSand(blockHit))
/*     */           {
/* 138 */             is.func_77964_b(81);
/* 139 */             if (world.field_73012_v.nextInt(10) == 0)
/* 140 */               world.func_147468_f(x, y, z); 
/* 141 */             TFC_Core.addPlayerExhaustion(player, 5.0E-4F);
/* 142 */             cd.sluicedAmount++;
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 147 */           TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("gui.goldpan.overused", new Object[0]));
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 152 */         int bMeta = world.func_72805_g(x, y + 1, z);
/* 153 */         if (world.func_147439_a(x, y + 1, z).func_149688_o() == Material.field_151586_h && bMeta > 0 && mop.field_72310_e == 1) {
/*     */           
/* 155 */           int uses = is.func_77960_j() >> 4;
/* 156 */           if (uses > 0) {
/*     */             
/* 158 */             int type = getMetalToDrop(world, player, x, y + 1, z);
/*     */             
/* 160 */             if (type != -1) {
/*     */               
/* 162 */               ItemStack out = new ItemStack(TFCItems.smallOreChunk, 1, type);
/* 163 */               world.func_72956_a((Entity)player, "random.pop", 0.7F, world.field_73012_v.nextFloat() + 1.0F);
/* 164 */               if (!player.field_71071_by.func_70441_a(out))
/*     */               {
/* 166 */                 player.func_71019_a(out, false);
/*     */               }
/* 168 */               TFC_Core.getSkillStats(player).increaseSkill("skill.prospecting", 1);
/*     */             } 
/* 170 */             uses--;
/* 171 */             if (uses > 0) {
/* 172 */               is.func_77964_b((is.func_77960_j() & 0xF) + (uses << 4));
/*     */             
/*     */             }
/* 175 */             else if (world.field_73012_v.nextInt(100) == 0) {
/*     */               
/* 177 */               world.func_72956_a((Entity)player, "terrafirmacraft:item.ceramicbreak", 0.7F, player.field_70170_p.field_73012_v.nextFloat() * 0.2F + 0.8F);
/* 178 */               is.field_77994_a--;
/*     */             } else {
/*     */               
/* 181 */               is.func_77964_b(0);
/*     */             }
/*     */           
/*     */           } 
/*     */         } else {
/*     */           
/* 187 */           TFC_Core.sendInfoMessage(player, (IChatComponent)new ChatComponentTranslation("gui.goldpan.useFlowing", new Object[0]));
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 192 */     return is;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getMetalToDrop(World world, EntityPlayer player, int x, int y, int z) {
/* 197 */     int type = -1;
/* 198 */     int chunkX = x >> 4 << 4;
/* 199 */     int chunkZ = z >> 4 << 4;
/* 200 */     Random rand = new Random(world.func_72905_C() + (((chunkX >> 3) - (chunkZ >> 3)) * (chunkZ >> 3)));
/* 201 */     int randType = rand.nextInt(100);
/* 202 */     SkillStats.SkillRank rank = TFC_Core.getSkillStats(player).getSkillRank("skill.prospecting");
/* 203 */     float skillMod = 1.0F - rank.ordinal() * 0.111F;
/*     */     
/* 205 */     if (randType > 25 && world.field_73012_v.nextInt((int)Math.floor((60.0F * skillMod))) == 0) type = 0; 
/* 206 */     if (rank.ordinal() > 0 && randType > 50 && world.field_73012_v.nextInt((int)Math.floor((120.0F * skillMod))) == 0) type = 4; 
/* 207 */     if (rank.ordinal() > 1 && randType > 75 && world.field_73012_v.nextInt((int)Math.floor((150.0F * skillMod))) == 0) type = 1; 
/* 208 */     if (world.field_73012_v.nextInt((int)Math.floor((500.0F * skillMod))) == 0) type = 2;
/*     */     
/* 210 */     return type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 216 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemGoldPan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
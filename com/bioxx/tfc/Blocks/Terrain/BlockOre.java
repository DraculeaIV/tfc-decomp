/*     */ package com.bioxx.tfc.Blocks.Terrain;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Climate;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEOre;
/*     */ import com.bioxx.tfc.WorldGen.DataLayer;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockOre
/*     */   extends BlockCollapsible
/*     */ {
/*  34 */   public String[] blockNames = Global.ORE_METAL;
/*     */   protected IIcon[] icons; public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) { if (TFCOptions.enableDebugMode && world.field_72995_K) {
/*     */       int metadata = world.func_72805_g(x, y, z); TerraFirmaCraft.LOG.info("Meta = " + func_149739_a() + ":" + metadata); TEOre te = (TEOre)world.func_147438_o(x, y, z); if (te != null)
/*     */         TerraFirmaCraft.LOG.info("Ore  BaseID = " + te.baseBlockID + "| BaseMeta =" + te.baseBlockMeta); 
/*  38 */     }  return false; } public BlockOre(Material mat) { super(mat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.icons = new IIcon[this.blockNames.length]; func_149675_a(true); func_149647_a(null); }
/*     */   public int[] getDropBlock(World world, int x, int y, int z) { int[] data = { -1, -1 }; DataLayer dl = TFC_Climate.getCacheManager(world).getRockLayerAt(x, z, TFC_Core.getRockLayerFromHeight(world, x, y, z)); if (dl != null) { BlockStone stone = null; if (dl.block instanceof BlockStone)
/*     */         stone = (BlockStone)dl.block;  if (stone != null) {
/*     */         data[0] = Block.func_149682_b(stone.dropBlock); data[1] = dl.data2;
/*     */       }  }
/* 107 */      return data; } public void func_149651_a(IIconRegister iconRegisterer) { for (int i = 0; i < this.blockNames.length; i++)
/* 108 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:ores/" + this.blockNames[i] + " Ore");  } public int func_149692_a(int dmg) { if (dmg == 14 || dmg == 15)
/*     */       return 0;  return dmg; }
/*     */   public int quantityDropped(int meta, int fortune, Random random) { if (meta == 14 || meta == 15)
/*     */       return 1 + random.nextInt(2);  return 1; }
/*     */   public IIcon func_149691_a(int side, int meta) { if (meta >= this.icons.length)
/*     */       return this.icons[0];  return this.icons[meta]; }
/* 114 */   public int func_149645_b() { return TFCBlocks.oreRenderId; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {
/* 120 */     if (!world.field_72995_K) {
/*     */       
/* 122 */       boolean dropOres = false;
/* 123 */       boolean hasHammer = false;
/* 124 */       int meta = world.func_72805_g(x, y, z);
/* 125 */       boolean isCoal = (meta == 14 || meta == 15);
/* 126 */       ItemStack itemstack = null;
/* 127 */       if (player != null) {
/*     */         
/* 129 */         TFC_Core.addPlayerExhaustion(player, 0.001F);
/* 130 */         player.func_71064_a(StatList.field_75934_C[func_149682_b((Block)this)], 1);
/* 131 */         dropOres = player.func_146099_a((Block)this);
/* 132 */         ItemStack heldItem = player.func_71045_bC();
/* 133 */         if (heldItem != null) {
/*     */           
/* 135 */           int[] itemIDs = OreDictionary.getOreIDs(heldItem);
/* 136 */           for (int id : itemIDs) {
/*     */             
/* 138 */             String name = OreDictionary.getOreName(id);
/* 139 */             if (name.startsWith("itemHammer")) {
/*     */               
/* 141 */               hasHammer = true;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 148 */       if (player == null || dropOres) {
/*     */         
/* 150 */         if (isCoal) {
/* 151 */           itemstack = new ItemStack(TFCItems.coal, 1 + world.field_73012_v.nextInt(2));
/*     */         } else {
/*     */           
/* 154 */           TEOre te = (TEOre)world.func_147438_o(x, y, z);
/* 155 */           int ore = getOreGrade(te, meta);
/* 156 */           itemstack = new ItemStack(TFCItems.oreChunk, 1, func_149692_a(ore));
/*     */         }
/*     */       
/* 159 */       } else if (hasHammer && !isCoal) {
/* 160 */         itemstack = new ItemStack(TFCItems.smallOreChunk, 1, meta);
/*     */       } 
/* 162 */       if (itemstack != null)
/* 163 */         func_149642_a(world, x, y, z, itemstack); 
/*     */     } 
/* 165 */     return world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 177 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 178 */     TEOre te = (TEOre)world.func_147438_o(x, y, z);
/* 179 */     int ore = getOreGrade(te, metadata);
/*     */     
/* 181 */     int count = quantityDropped(metadata, fortune, world.field_73012_v);
/* 182 */     for (int i = 0; i < count; i++) {
/*     */       ItemStack itemstack;
/*     */       
/* 185 */       if (metadata == 14 || metadata == 15) {
/* 186 */         itemstack = new ItemStack(TFCItems.coal);
/*     */       } else {
/* 188 */         itemstack = new ItemStack(TFCItems.oreChunk, 1, func_149692_a(ore));
/*     */       } 
/* 190 */       ret.add(itemstack);
/*     */     } 
/* 192 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Item getDroppedItem(int meta) {
/* 197 */     if (meta == 14 || meta == 15) {
/* 198 */       return TFCItems.coal;
/*     */     }
/* 200 */     return TFCItems.smallOreChunk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion exp) {
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion exp) {
/* 212 */     world.func_147468_f(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockExploded(World world, int x, int y, int z, Explosion exp) {
/* 218 */     if (!world.field_72995_K) {
/*     */       ItemStack itemstack;
/* 220 */       TEOre te = (TEOre)world.func_147438_o(x, y, z);
/* 221 */       Random random = new Random();
/*     */       
/* 223 */       int meta = world.func_72805_g(x, y, z);
/* 224 */       int ore = getOreGrade(te, meta);
/*     */       
/* 226 */       if (meta == 14 || meta == 15) {
/* 227 */         itemstack = new ItemStack(TFCItems.coal, 1 + random.nextInt(2));
/*     */       } else {
/* 229 */         itemstack = new ItemStack(TFCItems.oreChunk, 1, ore);
/*     */       } 
/* 231 */       func_149642_a(world, x, y, z, itemstack);
/* 232 */       func_149723_a(world, x, y, z, exp);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOreGrade(TEOre te, int ore) {
/* 238 */     if (te != null) {
/*     */       
/* 240 */       int grade = te.extraData & 0x7;
/* 241 */       if (grade == 1) {
/* 242 */         ore += 35;
/* 243 */       } else if (grade == 2) {
/* 244 */         ore += 49;
/*     */       } 
/* 246 */     }  return ore;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 252 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createTileEntity(World w, int meta) {
/* 258 */     return (TileEntity)new TEOre();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 264 */     if (!world.field_72995_K) {
/* 265 */       scanVisible(world, x, y, z);
/*     */     }
/*     */   }
/*     */   
/*     */   public void scanVisible(World world, int x, int y, int z) {
/* 270 */     if (!world.field_72995_K) {
/*     */       
/* 272 */       TEOre te = (TEOre)world.func_147438_o(x, y, z);
/* 273 */       if ((te.extraData & 0x8) == 0 && y < 255 && y > 0)
/*     */       {
/* 275 */         if (world.func_72899_e(x, y - 1, z) && world.func_72899_e(x, y + 1, z) && world.func_72899_e(x - 1, y, z) && world.func_72899_e(x + 1, y, z) && world
/* 276 */           .func_72899_e(x, y, z - 1) && world.func_72899_e(x, y, z + 1) && (
/* 277 */           !world.func_147439_a(x, y - 1, z).func_149662_c() || !world.func_147439_a(x, y + 1, z).func_149662_c() || 
/* 278 */           !world.func_147439_a(x - 1, y, z).func_149662_c() || !world.func_147439_a(x + 1, y, z).func_149662_c() || 
/* 279 */           !world.func_147439_a(x, y, z - 1).func_149662_c() || !world.func_147439_a(x, y, z + 1).func_149662_c()))
/*     */         {
/* 281 */           te.setVisible();
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 290 */     if (!world.field_72995_K)
/*     */     {
/* 292 */       scanVisible(world, x, y, z);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
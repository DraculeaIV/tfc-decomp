/*     */ package com.bioxx.tfc.Blocks.Flora;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerra;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLogNatural
/*     */   extends BlockTerra
/*     */ {
/*     */   protected String[] woodNames;
/*  33 */   private int searchDist = 10;
/*     */   
/*     */   private static int damage;
/*     */   private static int logs;
/*     */   private boolean isStone;
/*     */   public IIcon[] sideIcons;
/*     */   public IIcon[] innerIcons;
/*     */   public IIcon[] rotatedSideIcons;
/*     */   
/*     */   public BlockLogNatural() {
/*  43 */     super(Material.field_151575_d);
/*  44 */     func_149675_a(true);
/*  45 */     this.woodNames = new String[16];
/*  46 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/*  47 */     this.sideIcons = new IIcon[this.woodNames.length];
/*  48 */     this.innerIcons = new IIcon[this.woodNames.length];
/*  49 */     this.rotatedSideIcons = new IIcon[this.woodNames.length];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/*  55 */     if (!world.field_72995_K)
/*     */     {
/*  57 */       if (!world.func_147439_a(x, y - 1, z).func_149662_c())
/*     */       {
/*  59 */         if (noLogsNearby(world, x + 1, y, z) && noLogsNearby(world, x - 1, y, z) && 
/*  60 */           noLogsNearby(world, x, y, z + 1) && noLogsNearby(world, x, y, z - 1) && 
/*  61 */           noLogsNearby(world, x + 1, y, z + 1) && noLogsNearby(world, x + 1, y, z - 1) && 
/*  62 */           noLogsNearby(world, x - 1, y, z + 1) && noLogsNearby(world, x - 1, y, z - 1) && 
/*  63 */           noLogsNearby(world, x + 1, y - 1, z) && noLogsNearby(world, x - 1, y - 1, z) && 
/*  64 */           noLogsNearby(world, x, y - 1, z + 1) && noLogsNearby(world, x, y - 1, z - 1) && 
/*  65 */           noLogsNearby(world, x + 1, y - 1, z + 1) && noLogsNearby(world, x + 1, y - 1, z - 1) && 
/*  66 */           noLogsNearby(world, x - 1, y - 1, z + 1) && noLogsNearby(world, x - 1, y - 1, z - 1)) {
/*  67 */           world.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 2);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean noLogsNearby(World world, int x, int y, int z) {
/*  74 */     return (world.func_72899_e(x, y, z) && world.func_147439_a(x, y, z) != this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  84 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  85 */       list.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_149712_f(World world, int x, int y, int z) {
/*  91 */     return this.field_149782_v;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkOut(World world, int x, int y, int z, int meta) {
/*  96 */     return (world.func_147439_a(x, y, z) == this && world.func_72805_g(x, y, z) == meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/* 102 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 109 */     if (side == 0 || side == 1)
/* 110 */       return this.innerIcons[meta]; 
/* 111 */     return this.sideIcons[meta];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister reg) {
/* 117 */     for (int i = 0; i < this.woodNames.length; i++) {
/*     */       
/* 119 */       this.sideIcons[i] = reg.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Log");
/* 120 */       this.innerIcons[i] = reg.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Log Top");
/* 121 */       this.rotatedSideIcons[i] = reg.func_94245_a("terrafirmacraft:wood/trees/" + this.woodNames[i] + " Log Side");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
/* 129 */     boolean isAxe = false;
/* 130 */     boolean isHammer = false;
/* 131 */     ItemStack equip = entityplayer.func_71045_bC();
/* 132 */     if (!world.field_72995_K)
/*     */     {
/* 134 */       if (equip != null) {
/*     */         
/* 136 */         int[] equipIDs = OreDictionary.getOreIDs(equip);
/* 137 */         for (int id : equipIDs) {
/*     */           
/* 139 */           String name = OreDictionary.getOreName(id);
/* 140 */           if (name.startsWith("itemAxe")) {
/*     */             
/* 142 */             isAxe = true;
/* 143 */             if (name.startsWith("itemAxeStone")) {
/*     */               
/* 145 */               this.isStone = true;
/*     */               
/*     */               break;
/*     */             } 
/* 149 */           } else if (name.startsWith("itemHammer")) {
/*     */             
/* 151 */             isHammer = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 156 */         if (isAxe) {
/*     */           
/* 158 */           damage = -1;
/* 159 */           processTree(world, x, y, z, meta, equip);
/*     */           
/* 161 */           if (damage + equip.func_77960_j() > equip.func_77958_k()) {
/*     */             
/* 163 */             int ind = entityplayer.field_71071_by.field_70461_c;
/* 164 */             entityplayer.field_71071_by.func_70299_a(ind, null);
/* 165 */             world.func_147465_d(x, y, z, (Block)this, meta, 2);
/*     */           } else {
/*     */             
/* 168 */             equip.func_77972_a(damage, (EntityLivingBase)entityplayer);
/*     */           } 
/* 170 */           int smallStack = logs % 16;
/* 171 */           func_149642_a(world, x, y, z, new ItemStack(TFCItems.logs, smallStack, func_149692_a(meta)));
/* 172 */           logs -= smallStack;
/*     */ 
/*     */           
/* 175 */           while (logs > 0)
/*     */           {
/* 177 */             func_149642_a(world, x, y, z, new ItemStack(TFCItems.logs, 16, func_149692_a(meta)));
/* 178 */             logs -= 16;
/*     */           }
/*     */         
/*     */         }
/* 182 */         else if (isHammer) {
/*     */           
/* 184 */           EntityItem item = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, new ItemStack(TFCItems.stick, 1 + world.field_73012_v.nextInt(3)));
/* 185 */           world.func_72838_d((Entity)item);
/*     */         } 
/*     */       } else {
/*     */         
/* 189 */         world.func_147465_d(x, y, z, (Block)this, meta, 2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149681_a(World world, int x, int y, int z, int side, EntityPlayer entityplayer) {
/* 196 */     int meta = world.func_72805_g(x, y, z);
/* 197 */     func_149636_a(world, entityplayer, x, y, z, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/* 203 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion ex) {
/* 215 */     processTree(world, x, y, z, world.func_72805_g(x, y, z), (ItemStack)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   private void processTree(World world, int x, int y, int z, int meta, ItemStack is) {
/* 227 */     boolean[][][] checkArray = new boolean[this.searchDist * 2 + 1][256][this.searchDist * 2 + 1];
/* 228 */     scanLogs(world, x, y, z, meta, checkArray, (byte)0, (byte)0, (byte)0, is);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int i, Random random, int j) {
/* 234 */     return TFCItems.logs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 240 */     int meta = world.func_72805_g(x, y, z);
/* 241 */     boolean check = false;
/* 242 */     for (int h = -2; h <= 2; h++) {
/*     */       
/* 244 */       for (int g = -2; g <= 2; g++) {
/*     */         
/* 246 */         for (int f = -2; f <= 2; f++) {
/*     */           
/* 248 */           if (world.func_147439_a(x + h, y + g, z + f) == this && world.func_72805_g(x + h, y + g, z + f) == meta)
/* 249 */             check = true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 253 */     if (!check) {
/*     */       
/* 255 */       world.func_147468_f(x, y, z);
/* 256 */       func_149642_a(world, x, y, z, new ItemStack(TFCItems.logs, 1, meta));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void scanLogs(World world, int i, int j, int k, int meta, boolean[][][] checkArray, byte x, byte y, byte z, ItemStack stack) {
/* 263 */     if (y >= 0 && j + y < 256) {
/*     */       
/* 265 */       int offsetX = 0, offsetY = 0, offsetZ = 0;
/* 266 */       checkArray[x + this.searchDist][y][z + this.searchDist] = true;
/*     */       
/* 268 */       for (offsetX = -3; offsetX <= 3; offsetX++) {
/*     */         
/* 270 */         for (offsetZ = -3; offsetZ <= 3; offsetZ++) {
/*     */           
/* 272 */           for (offsetY = 0; offsetY <= 2; offsetY++) {
/*     */             
/* 274 */             if (Math.abs(x + offsetX) <= this.searchDist && j + y + offsetY < 256 && Math.abs(z + offsetZ) <= this.searchDist)
/*     */             {
/* 276 */               if (checkOut(world, i + x + offsetX, j + y + offsetY, k + z + offsetZ, meta) && (offsetX != 0 || offsetY != 0 || offsetZ != 0) && !checkArray[x + offsetX + this.searchDist][y + offsetY][z + offsetZ + this.searchDist])
/*     */               {
/*     */                 
/* 279 */                 scanLogs(world, i, j, k, meta, checkArray, (byte)(x + offsetX), (byte)(y + offsetY), (byte)(z + offsetZ), stack);
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 285 */       damage++;
/* 286 */       if (stack != null) {
/*     */         
/* 288 */         if (damage + stack.func_77960_j() <= stack.func_77958_k())
/*     */         {
/* 290 */           world.func_147465_d(i + x, j + y, k + z, Blocks.field_150350_a, 0, 2);
/* 291 */           if (!this.isStone || world.field_73012_v.nextInt(10) != 0)
/* 292 */             logs++; 
/* 293 */           if (logs >= 16) {
/*     */             
/* 295 */             func_149642_a(world, i + x, j + y, k + z, new ItemStack(TFCItems.logs, 16, func_149692_a(meta)));
/* 296 */             logs -= 16;
/*     */           } 
/* 298 */           notifyLeaves(world, i + x, j + y, k + z);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 303 */         world.func_147468_f(i, j, k);
/* 304 */         logs++;
/* 305 */         if (logs >= 16) {
/*     */           
/* 307 */           func_149642_a(world, i, j, k, new ItemStack(TFCItems.logs, 16, func_149692_a(meta)));
/* 308 */           logs -= 16;
/*     */         } 
/* 310 */         notifyLeaves(world, i + x, j + y, k + z);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyLeaves(World world, int x, int y, int z) {
/* 317 */     world.func_147460_e(x + 1, y, z, Blocks.field_150350_a);
/* 318 */     world.func_147460_e(x - 1, y, z, Blocks.field_150350_a);
/* 319 */     world.func_147460_e(x, y, z + 1, Blocks.field_150350_a);
/* 320 */     world.func_147460_e(x, y, z - 1, Blocks.field_150350_a);
/* 321 */     world.func_147460_e(x, y + 1, z, Blocks.field_150350_a);
/* 322 */     world.func_147460_e(x, y - 1, z, Blocks.field_150350_a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Flora\BlockLogNatural.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
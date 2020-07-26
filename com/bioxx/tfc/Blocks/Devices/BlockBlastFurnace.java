/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEBlastFurnace;
/*     */ import com.bioxx.tfc.TileEntities.TEMetalSheet;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockBlastFurnace
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private IIcon[] textureSide;
/*     */   private IIcon textureOn;
/*     */   private IIcon textureOff;
/*     */   
/*     */   public BlockBlastFurnace() {
/*  33 */     super(Material.field_151576_e);
/*  34 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/*  40 */     int meta = world.func_72805_g(x, y, z) & 0x4;
/*  41 */     if (meta == 0) {
/*  42 */       return 0;
/*     */     }
/*  44 */     return 15;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
/*  50 */     ItemStack equippedItem = entityplayer.func_71045_bC();
/*  51 */     if (!world.field_72995_K)
/*     */     {
/*  53 */       if (!func_149718_j(world, i, j, k)) {
/*     */         
/*  55 */         world.func_147468_f(i, j, k);
/*  56 */         world.func_72838_d((Entity)new EntityItem(world, i, j, k, new ItemStack((Block)this, 1)));
/*     */       }
/*  58 */       else if (world.func_147438_o(i, j, k) != null) {
/*     */         
/*  60 */         TEBlastFurnace te = (TEBlastFurnace)world.func_147438_o(i, j, k);
/*     */         
/*  62 */         if (te.isValid) {
/*     */           
/*  64 */           if (equippedItem != null && (equippedItem.func_77973_b() == TFCItems.fireStarter || equippedItem.func_77973_b() == TFCItems.flintSteel) && 
/*  65 */             te.canLight()) {
/*  66 */             entityplayer.func_71045_bC().func_77972_a(1, (EntityLivingBase)entityplayer);
/*     */           }
/*  68 */           entityplayer.openGui(TerraFirmaCraft.instance, 26, world, i, j, k);
/*     */         } 
/*     */       } 
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int i, int j, int k) {
/*  78 */     return checkStackAt(world, i, j + 1, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkStackAt(World world, int x, int y, int z) {
/*  83 */     return (checkBlock(world, x + 1, y, z, x, z) && checkBlock(world, x - 1, y, z, x, z) && checkBlock(world, x, y, z + 1, x, z) && 
/*  84 */       checkBlock(world, x, y, z - 1, x, z) && (world.func_147437_c(x, y, z) || world.func_147439_a(x, y, z) == TFCBlocks.molten));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkBlock(World world, int x, int y, int z, int stackX, int stackZ) {
/*  89 */     if (!world.func_72899_e(x, y, z) || world.func_147439_a(x, y, z) != TFCBlocks.fireBrick) {
/*  90 */       return false;
/*     */     }
/*  92 */     int count = 0;
/*  93 */     int xCoord = x - 1;
/*  94 */     int zCoord = z;
/*  95 */     if (world.func_72899_e(xCoord, y, zCoord) && (xCoord != stackX || zCoord != stackZ) && world
/*  96 */       .func_147439_a(xCoord, y, zCoord) == TFCBlocks.metalSheet && world.func_147438_o(xCoord, y, zCoord) instanceof TEMetalSheet) {
/*     */       
/*  98 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(xCoord, y, zCoord);
/*  99 */       if (!te.westExists() || !isValidMetalSheet(te))
/* 100 */         return false; 
/* 101 */       count++;
/*     */     } 
/* 103 */     xCoord = x + 1;
/* 104 */     zCoord = z;
/* 105 */     if (world.func_72899_e(xCoord, y, zCoord) && (xCoord != stackX || zCoord != stackZ) && world
/* 106 */       .func_147439_a(xCoord, y, zCoord) == TFCBlocks.metalSheet && world.func_147438_o(xCoord, y, zCoord) instanceof TEMetalSheet) {
/*     */       
/* 108 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(xCoord, y, zCoord);
/* 109 */       if (!te.eastExists() || !isValidMetalSheet(te))
/* 110 */         return false; 
/* 111 */       count++;
/*     */     } 
/* 113 */     xCoord = x;
/* 114 */     zCoord = z - 1;
/* 115 */     if (world.func_72899_e(xCoord, y, zCoord) && (xCoord != stackX || zCoord != stackZ) && world
/* 116 */       .func_147439_a(xCoord, y, zCoord) == TFCBlocks.metalSheet && world.func_147438_o(xCoord, y, zCoord) instanceof TEMetalSheet) {
/*     */       
/* 118 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(xCoord, y, zCoord);
/* 119 */       if (!te.southExists() || !isValidMetalSheet(te))
/* 120 */         return false; 
/* 121 */       count++;
/*     */     } 
/* 123 */     xCoord = x;
/* 124 */     zCoord = z + 1;
/* 125 */     if (world.func_72899_e(xCoord, y, zCoord) && (xCoord != stackX || zCoord != stackZ) && world
/* 126 */       .func_147439_a(xCoord, y, zCoord) == TFCBlocks.metalSheet && world.func_147438_o(xCoord, y, zCoord) instanceof TEMetalSheet) {
/*     */       
/* 128 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(xCoord, y, zCoord);
/* 129 */       if (!te.northExists() || !isValidMetalSheet(te))
/* 130 */         return false; 
/* 131 */       count++;
/*     */     } 
/* 133 */     return (count >= 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValidMetalSheet(TEMetalSheet te) {
/* 138 */     if (te != null) {
/*     */       
/* 140 */       ItemStack sheet = te.sheetStack;
/* 141 */       if (sheet != null && (sheet
/* 142 */         .func_77973_b() == TFCItems.wroughtIronSheet || sheet
/* 143 */         .func_77973_b() == TFCItems.steelSheet || sheet
/* 144 */         .func_77973_b() == TFCItems.blackSteelSheet || sheet
/* 145 */         .func_77973_b() == TFCItems.blueSteelSheet || sheet
/* 146 */         .func_77973_b() == TFCItems.redSteelSheet))
/* 147 */         return true; 
/*     */     } 
/* 149 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World world, int i, int j, int k) {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/* 161 */     int lit = ((j & 0x4) == 4) ? 1 : 0;
/* 162 */     j &= 0x3;
/*     */     
/* 164 */     if (i == 0 || i == 1) {
/*     */       
/* 166 */       if (lit == 1) {
/* 167 */         return this.textureSide[1];
/*     */       }
/* 169 */       return this.textureSide[0];
/*     */     } 
/*     */ 
/*     */     
/* 173 */     if (lit == 1) {
/* 174 */       return this.textureOn;
/*     */     }
/* 176 */     return this.textureOff;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 183 */     this.textureSide = new IIcon[2];
/* 184 */     this.textureSide[0] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Blast Furnace Bottom Off");
/* 185 */     this.textureSide[1] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Blast Furnace Bottom On");
/* 186 */     this.textureOn = iconRegisterer.func_94245_a("terrafirmacraft:devices/Blast Furnace On");
/* 187 */     this.textureOff = iconRegisterer.func_94245_a("terrafirmacraft:devices/Blast Furnace Off");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack par6ItemStack) {
/* 193 */     if (!world.field_72995_K) {
/*     */       
/* 195 */       int l = MathHelper.func_76128_c((entityliving.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 196 */       world.func_72921_c(i, j, k, l, 2);
/* 197 */       if (!func_149718_j(world, i, j, k)) {
/*     */         
/* 199 */         world.func_147468_f(i, j, k);
/* 200 */         world.func_72838_d((Entity)new EntityItem(world, i, j, k, new ItemStack((Block)this, 1)));
/*     */       }
/*     */       else {
/*     */         
/* 204 */         ((TEBlastFurnace)world.func_147438_o(i, j, k)).slowCounter = 101;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removedByPlayer(World world, EntityPlayer player, int i, int j, int k) {
/* 212 */     if (!world.field_72995_K) {
/*     */       
/* 214 */       world.func_72805_g(i, j, k);
/*     */       
/* 216 */       if (world.func_147439_a(i, j, k) == TFCBlocks.molten)
/* 217 */         world.func_147468_f(i, j, k); 
/* 218 */       if (world.func_147439_a(i, j + 1, k) == TFCBlocks.molten)
/* 219 */         world.func_147468_f(i, j + 1, k); 
/* 220 */       if (world.func_147439_a(i, j + 2, k) == TFCBlocks.molten)
/* 221 */         world.func_147468_f(i, j + 2, k); 
/* 222 */       if (world.func_147439_a(i, j + 3, k) == TFCBlocks.molten)
/* 223 */         world.func_147468_f(i, j + 3, k); 
/* 224 */       if (world.func_147439_a(i, j + 4, k) == TFCBlocks.molten)
/* 225 */         world.func_147468_f(i, j + 4, k); 
/* 226 */       world.func_147468_f(i, j, k);
/*     */     } 
/* 228 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block block) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 245 */     return (TileEntity)new TEBlastFurnace();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
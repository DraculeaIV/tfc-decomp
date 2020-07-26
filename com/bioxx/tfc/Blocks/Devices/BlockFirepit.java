/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEFirepit;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFirepit
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private IIcon textureOn;
/*     */   private IIcon textureOff;
/*     */   
/*     */   public BlockFirepit() {
/*  40 */     super(Material.field_151578_c);
/*  41 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  47 */     if (!world.field_72995_K) {
/*     */       
/*  49 */       ItemStack equippedItem = entityplayer.func_71045_bC();
/*  50 */       if (equippedItem != null) {
/*     */         
/*  52 */         Item item = entityplayer.func_71045_bC().func_77973_b();
/*  53 */         if (item instanceof com.bioxx.tfc.Items.Tools.ItemFirestarter || item instanceof net.minecraft.item.ItemFlintAndSteel)
/*     */         {
/*  55 */           if ((TEFirepit)world.func_147438_o(x, y, z) != null) {
/*     */             
/*  57 */             TEFirepit te = (TEFirepit)world.func_147438_o(x, y, z);
/*  58 */             if (te.fireTemp < 210.0F && te.fireItemStacks[5] != null) {
/*     */               
/*  60 */               te.fireTemp = 300.0F;
/*  61 */               if (item instanceof net.minecraft.item.ItemFlintAndSteel) {
/*     */                 
/*  63 */                 Random rand = new Random();
/*  64 */                 world.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
/*     */               } 
/*  66 */               equippedItem.func_77972_a(1, (EntityLivingBase)entityplayer);
/*  67 */               world.func_72921_c(x, y, z, 1, 3);
/*  68 */               return true;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/*  74 */       if ((TEFirepit)world.func_147438_o(x, y, z) != null) {
/*  75 */         entityplayer.openGui(TerraFirmaCraft.instance, 20, world, x, y, z);
/*     */       }
/*     */     } 
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  84 */     if (j > 0)
/*  85 */       return this.textureOn; 
/*  86 */     return this.textureOff;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  92 */     return TFCBlocks.firepitRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random rand) {
/* 104 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 110 */     if (!TFC_Core.isTopFaceSolid(world, x, y - 1, z)) {
/*     */       
/* 112 */       ((TEFirepit)world.func_147438_o(x, y, z)).ejectContents();
/* 113 */       world.func_147468_f(x, y, z);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149734_b(World world, int x, int y, int z, Random rand) {
/* 121 */     int meta = world.func_72805_g(x, y, z);
/* 122 */     if (meta >= 1) {
/*     */       
/* 124 */       if (rand.nextInt(24) == 0) {
/* 125 */         world.func_72908_a(x, y, z, "fire.fire", 0.4F + rand.nextFloat() / 2.0F, 0.7F + rand.nextFloat());
/*     */       }
/* 127 */       float f = x + 0.5F;
/* 128 */       float f1 = y + 0.1F + rand.nextFloat() * 6.0F / 16.0F;
/* 129 */       float f2 = z + 0.5F;
/*     */       
/* 131 */       float f4 = rand.nextFloat() * 0.6F;
/* 132 */       float f5 = rand.nextFloat() * -0.6F;
/* 133 */       float f6 = rand.nextFloat() * -0.6F;
/* 134 */       world.func_72869_a("smoke", (f + f4 - 0.3F), f1, (f2 + f5 + 0.3F), 0.0D, 0.0D, 0.0D);
/* 135 */       world.func_72869_a("flame", (f + f4 - 0.3F), f1, (f2 + f5 + 0.3F), 0.0D, 0.0D, 0.0D);
/* 136 */       world.func_72869_a("smoke", (f + f5 + 0.3F), f1, (f2 + f4 - 0.3F), 0.0D, 0.0D, 0.0D);
/* 137 */       world.func_72869_a("flame", (f + f5 + 0.3F), f1, (f2 + f4 - 0.3F), 0.0D, 0.0D, 0.0D);
/* 138 */       if (((TEFirepit)world.func_147438_o(x, y, z)).fireTemp > 550.0F) {
/*     */         
/* 140 */         world.func_72869_a("flame", (f + f5 + 0.3F), f1, (f2 + f6 + 0.2F), 0.0D, 0.0D, 0.0D);
/* 141 */         world.func_72869_a("flame", (f + f4 - 0.3F), f1, (f2 + f6 + 0.1F), 0.0D, 0.0D, 0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 149 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/* 155 */     int meta = world.func_72805_g(x, y, z);
/* 156 */     if (meta == 0)
/* 157 */       return 0; 
/* 158 */     if (meta == 1) {
/* 159 */       return 10;
/*     */     }
/* 161 */     return 15;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149636_a(World world, EntityPlayer entityplayer, int x, int y, int z, int meta) {
/* 177 */     eject(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World world, int x, int y, int z, Explosion exp) {
/* 183 */     eject(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149664_b(World world, int x, int y, int z, int meta) {
/* 189 */     eject(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void eject(World world, int x, int y, int z) {
/* 196 */     if (world.func_147438_o(x, y, z) instanceof TEFirepit) {
/*     */       
/* 198 */       TEFirepit te = (TEFirepit)world.func_147438_o(x, y, z);
/* 199 */       te.ejectContents();
/* 200 */       world.func_147475_p(x, y, z);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess bAccess, int x, int y, int z) {
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 213 */     return (TileEntity)new TEFirepit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 219 */     this.textureOn = iconRegisterer.func_94245_a("terrafirmacraft:devices/Firepit On");
/* 220 */     this.textureOff = iconRegisterer.func_94245_a("terrafirmacraft:devices/Firepit Off");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 226 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149702_O() {
/* 236 */     return "terrafirmacraft:devices/firepit";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World world, int x, int y, int z, Entity entity) {
/* 246 */     if (world.func_72805_g(x, y, z) >= 1 && !entity.func_70045_F() && entity instanceof EntityLivingBase)
/*     */     {
/*     */       
/* 249 */       entity.func_70015_d(2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
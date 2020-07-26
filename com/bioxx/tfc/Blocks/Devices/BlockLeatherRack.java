/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.TileEntities.TELeatherRack;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLeatherRack
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public IIcon scrapedTex;
/*     */   
/*     */   public BlockLeatherRack() {
/*  34 */     super(Material.field_151575_d);
/*  35 */     func_149647_a(null);
/*  36 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.001F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  42 */     if (!world.field_72995_K && world.func_147438_o(x, y, z) instanceof TELeatherRack) {
/*     */       
/*  44 */       TELeatherRack te = (TELeatherRack)world.func_147438_o(x, y, z);
/*  45 */       ItemStack equipped = entityplayer.func_71045_bC();
/*     */       
/*  47 */       if (te.workedArea != -1 && equipped != null && equipped.func_77973_b() instanceof com.bioxx.tfc.api.Tools.IKnife) {
/*     */         
/*  49 */         int coord = (int)Math.floor((hitX / 0.25F)) + (int)Math.floor((hitZ / 0.25F)) * 4;
/*  50 */         if ((te.workedArea >> coord & 0x1) == 0)
/*     */         {
/*  52 */           te.workArea(coord);
/*  53 */           NBTTagCompound nbt = new NBTTagCompound();
/*  54 */           nbt.func_74777_a("workedArea", te.workedArea);
/*  55 */           te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*  56 */           equipped.func_77972_a(1, (EntityLivingBase)entityplayer);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/*  61 */         world.func_147468_f(x, y, z);
/*     */       } 
/*     */     } 
/*     */     
/*  65 */     if (!func_149718_j(world, x, y, z))
/*     */     {
/*  67 */       world.func_147468_f(x, y, z);
/*     */     }
/*     */     
/*  70 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149718_j(World world, int x, int y, int z) {
/*  76 */     if (world.func_147438_o(x, y, z) instanceof TELeatherRack) {
/*     */       
/*  78 */       TELeatherRack te = (TELeatherRack)world.func_147438_o(x, y, z);
/*  79 */       if (te.leatherItem == null)
/*     */       {
/*  81 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  85 */     return (world.func_147439_a(x, y - 1, z).func_149688_o() == Material.field_151575_d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int i, int j, int k, Block par5) {
/*  91 */     super.func_149695_a(world, i, j, k, par5);
/*  92 */     if (!func_149718_j(world, i, j, k)) {
/*  93 */       world.func_147465_d(i, j, k, Blocks.field_150350_a, 0, 2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int i, int j, int k, int meta) {
/*  99 */     if (!world.field_72995_K && world.func_147438_o(i, j, k) instanceof TELeatherRack) {
/*     */       
/* 101 */       TELeatherRack te = (TELeatherRack)world.func_147438_o(i, j, k);
/* 102 */       if (te.leatherItem != null) {
/*     */         
/* 104 */         EntityItem ei = new EntityItem(world, i, j, k, te.leatherItem);
/* 105 */         ei.field_70159_w = 0.0D;
/* 106 */         ei.field_70179_y = 0.0D;
/* 107 */         world.func_72838_d((Entity)ei);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 139 */     return TFCBlocks.leatherRackRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 145 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:Soaked Hide");
/* 146 */     this.scrapedTex = iconRegisterer.func_94245_a("terrafirmacraft:Scraped Hide");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess access, int x, int y, int z, int side) {
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int var2) {
/* 159 */     return (TileEntity)new TELeatherRack();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockLeatherRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
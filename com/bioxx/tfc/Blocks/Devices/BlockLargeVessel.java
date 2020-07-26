/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.TileEntities.TEVessel;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLargeVessel
/*     */   extends BlockBarrel
/*     */ {
/*     */   private IIcon[] clayIcons;
/*     */   private IIcon[] ceramicIcons;
/*     */   
/*     */   public BlockLargeVessel() {
/*  31 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*  32 */     func_149676_a(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  40 */     par3List.add(new ItemStack((Block)this, 1, 0));
/*  41 */     par3List.add(new ItemStack((Block)this, 1, 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  47 */     this.ceramicIcons = new IIcon[3];
/*  48 */     this.clayIcons = new IIcon[3];
/*  49 */     this.ceramicIcons[0] = iconRegisterer.func_94245_a("terrafirmacraft:clay/Ceramic Vessel Top");
/*  50 */     this.ceramicIcons[1] = iconRegisterer.func_94245_a("terrafirmacraft:clay/Ceramic Vessel Side");
/*  51 */     this.ceramicIcons[2] = iconRegisterer.func_94245_a("terrafirmacraft:clay/Ceramic Vessel Bottom");
/*  52 */     this.clayIcons[0] = iconRegisterer.func_94245_a("terrafirmacraft:clay/Clay Vessel Top");
/*  53 */     this.clayIcons[1] = iconRegisterer.func_94245_a("terrafirmacraft:clay/Clay Vessel Side");
/*  54 */     this.clayIcons[2] = iconRegisterer.func_94245_a("terrafirmacraft:clay/Clay Vessel Bottom");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  60 */     if (meta == 1) {
/*     */       
/*  62 */       if (side == 1)
/*  63 */         return this.ceramicIcons[0]; 
/*  64 */       if (side == 0) {
/*  65 */         return this.ceramicIcons[2];
/*     */       }
/*  67 */       return this.ceramicIcons[1];
/*     */     } 
/*  69 */     if (side == 1)
/*  70 */       return this.clayIcons[0]; 
/*  71 */     if (side == 0) {
/*  72 */       return this.clayIcons[2];
/*     */     }
/*  74 */     return this.clayIcons[1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/*  80 */     int meta = access.func_72805_g(x, y, z);
/*  81 */     if (meta == 1) {
/*     */       
/*  83 */       if (side == 1)
/*  84 */         return this.ceramicIcons[0]; 
/*  85 */       if (side == 0) {
/*  86 */         return this.ceramicIcons[2];
/*     */       }
/*  88 */       return this.ceramicIcons[1];
/*     */     } 
/*  90 */     if (side == 1)
/*  91 */       return this.clayIcons[0]; 
/*  92 */     if (side == 0) {
/*  93 */       return this.clayIcons[2];
/*     */     }
/*  95 */     return this.clayIcons[1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 114 */     return TFCBlocks.vesselRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/* 120 */     if (world.field_72995_K) {
/*     */       
/* 122 */       world.func_147471_g(x, y, z);
/* 123 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 127 */     if (player.func_70093_af())
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     if (world.func_147438_o(x, y, z) != null) {
/*     */       
/* 134 */       TEVessel te = (TEVessel)world.func_147438_o(x, y, z);
/*     */       
/* 136 */       if (!handleInteraction(player, (TEBarrel)te)) {
/*     */         
/* 138 */         if (te.getInvCount() == 0) {
/* 139 */           player.openGui(TerraFirmaCraft.instance, 46, world, x, y, z);
/*     */         } else {
/* 141 */           player.openGui(TerraFirmaCraft.instance, 47, world, x, y, z);
/* 142 */         }  return true;
/*     */       } 
/* 144 */       return true;
/*     */     } 
/*     */     
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 153 */     return (TileEntity)new TEVessel();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockLargeVessel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
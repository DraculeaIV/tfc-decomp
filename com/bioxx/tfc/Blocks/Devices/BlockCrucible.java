/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.Metal.MetalPair;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TECrucible;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCrucible
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private IIcon[] icons;
/*     */   
/*     */   public BlockCrucible() {
/*  37 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*  38 */     func_149676_a(0.0625F, 0.25F, 0.0625F, 0.9375F, 0.9375F, 0.9375F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int i, int j, int k, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
/*  44 */     if (!world.field_72995_K && (TECrucible)world.func_147438_o(i, j, k) != null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  49 */       entityplayer.openGui(TerraFirmaCraft.instance, 37, world, i, j, k);
/*     */     }
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int i, int j, int k, Block block, int par6) {
/*  57 */     if (world.func_147438_o(i, j, k) instanceof TECrucible) {
/*     */       
/*  59 */       TECrucible te = (TECrucible)world.func_147438_o(i, j, k);
/*     */       
/*  61 */       ItemStack is = new ItemStack(Item.func_150898_a(block), 1);
/*  62 */       NBTTagCompound nbt = writeCrucibleToNBT(te);
/*  63 */       is.func_77982_d(nbt);
/*  64 */       EntityItem ei = new EntityItem(world, i, j, k, is);
/*  65 */       world.func_72838_d((Entity)ei);
/*     */       
/*  67 */       for (int s = 0; s < te.func_70302_i_(); s++)
/*     */       {
/*  69 */         te.func_70299_a(s, null);
/*     */       }
/*     */     } 
/*  72 */     super.func_149749_a(world, i, j, k, block, par6);
/*     */   }
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
/*     */   protected void func_149642_a(World par1World, int par2, int par3, int par4, ItemStack par5ItemStack) {}
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
/*     */   public NBTTagCompound writeCrucibleToNBT(TECrucible te) {
/*  99 */     NBTTagCompound nbt = new NBTTagCompound();
/*     */     
/* 101 */     nbt.func_74768_a("temp", te.temperature);
/*     */     
/* 103 */     NBTTagList nbttaglist = new NBTTagList();
/* 104 */     Iterator<MetalPair> iter = te.metals.values().iterator();
/* 105 */     while (iter.hasNext()) {
/*     */       
/* 107 */       MetalPair m = iter.next();
/* 108 */       if (m != null) {
/*     */         
/* 110 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 111 */         nbttagcompound1.func_74768_a("ID", Item.func_150891_b(m.type.ingot));
/* 112 */         nbttagcompound1.func_74776_a("AmountF", m.amount);
/* 113 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 116 */     nbt.func_74782_a("Metals", (NBTBase)nbttaglist);
/*     */     
/* 118 */     nbttaglist = new NBTTagList();
/* 119 */     for (int i = 0; i < te.storage.length; i++) {
/*     */       
/* 121 */       if (te.storage[i] != null) {
/*     */         
/* 123 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 124 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 125 */         te.storage[i].func_77955_b(nbttagcompound1);
/* 126 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     nbt.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     
/* 132 */     return nbt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase player, ItemStack is) {
/* 138 */     super.func_149689_a(world, i, j, k, player, is);
/* 139 */     TECrucible te = (TECrucible)world.func_147438_o(i, j, k);
/*     */     
/* 141 */     if (te != null && is.func_77942_o())
/*     */     {
/* 143 */       te.readFromItemNBT(is.func_77978_p());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 151 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 157 */     this.icons = new IIcon[2];
/* 158 */     this.icons[0] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Crucible Top");
/* 159 */     this.icons[1] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Crucible Side");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/* 165 */     if (i < 2)
/*     */     {
/* 167 */       return this.icons[0];
/*     */     }
/*     */     
/* 170 */     return this.icons[1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 176 */     return TFCBlocks.crucibleRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 182 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 194 */     return (TileEntity)new TECrucible();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
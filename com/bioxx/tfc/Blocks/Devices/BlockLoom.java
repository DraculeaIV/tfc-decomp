/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Items.ItemBlocks.ItemBarrels;
/*     */ import com.bioxx.tfc.TileEntities.TELoom;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockLoom
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private String[] woodNames;
/*     */   
/*     */   public BlockLoom() {
/*  43 */     super(Material.field_151575_d);
/*  44 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*  45 */     func_149676_a(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
/*  46 */     this.woodNames = Global.WOOD_ALL;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  52 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:wood/BarrelHoop");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  59 */     if (side >= 10) {
/*     */       
/*  61 */       side -= 10;
/*  62 */       if (side == 0 || side == 1) {
/*  63 */         return TFC_Textures.invisibleTexture;
/*     */       }
/*  65 */       return this.field_149761_L;
/*     */     } 
/*  67 */     if (meta < 16)
/*  68 */       return TFCBlocks.planks.func_149691_a(side, meta); 
/*  69 */     return TFCBlocks.planks2.func_149691_a(side, meta - 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149673_e(IBlockAccess access, int x, int y, int z, int side) {
/*  77 */     if (side == 0 || side == 1) {
/*  78 */       return TFC_Textures.invisibleTexture;
/*     */     }
/*  80 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> par3List) {
/*  87 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  88 */       par3List.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  94 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 112 */     return TFCBlocks.loomRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World par1World, int par2, int par3, int par4) {
/* 121 */     super.func_149726_b(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase player, ItemStack is) {
/* 135 */     super.func_149689_a(world, i, j, k, player, is);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int par1) {
/* 151 */     int j = 0;
/* 152 */     String s = func_149739_a();
/* 153 */     for (int i = 0; i < this.woodNames.length; i++)
/* 154 */       j = (s.substring(s.indexOf('l', s.length())) == ((ItemBarrels)TFCItems.loom).metaNames[i]) ? i : 0; 
/* 155 */     return new ItemStack(TFCItems.loom, 1, j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block block, int meta) {
/* 164 */     if (world.func_147438_o(x, y, z) instanceof TELoom) {
/*     */       
/* 166 */       TELoom te = (TELoom)world.func_147438_o(x, y, z);
/*     */       
/* 168 */       ItemStack is = new ItemStack(Item.func_150898_a(block), 1, te.loomType);
/* 169 */       NBTTagCompound nbt = writeLoomToNBT(te);
/* 170 */       is.func_77982_d(nbt);
/* 171 */       EntityItem ei = new EntityItem(world, x, y, z, is);
/* 172 */       world.func_72838_d((Entity)ei);
/* 173 */       te.dropItem();
/* 174 */       for (int s = 0; s < te.func_70302_i_(); s++)
/* 175 */         te.func_70299_a(s, null); 
/*     */     } 
/* 177 */     super.func_149749_a(world, x, y, z, block, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_149642_a(World par1World, int par2, int par3, int par4, ItemStack par5ItemStack) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeLoomToNBT(TELoom te) {
/* 187 */     NBTTagCompound nbt = new NBTTagCompound();
/*     */     
/* 189 */     nbt.func_74768_a("loomType", te.loomType);
/*     */     
/* 191 */     return nbt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/* 197 */     if (world.field_72995_K) {
/*     */       
/* 199 */       world.func_147471_g(x, y, z);
/* 200 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 204 */     TileEntity te = world.func_147438_o(x, y, z);
/* 205 */     if (te instanceof TELoom) {
/*     */       
/* 207 */       TELoom loomTE = (TELoom)te;
/*     */       
/* 209 */       if (!loomTE.isFinished()) {
/* 210 */         if (!loomTE.canWeave()) {
/* 211 */           loomTE.addString(player.func_71045_bC());
/*     */         }
/* 213 */         else if (player.func_70093_af()) {
/*     */           
/* 215 */           loomTE.setIsWeaving(true);
/*     */         }
/*     */       
/* 218 */       } else if (!player.func_70093_af()) {
/*     */         
/* 220 */         ItemStack item = loomTE.takeFinishedCloth();
/* 221 */         if (item != null) {
/*     */           
/* 223 */           EntityItem entityitem = new EntityItem(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, item);
/* 224 */           world.func_72838_d((Entity)entityitem);
/*     */         } 
/*     */       } 
/*     */     } 
/* 228 */     if (player.func_70093_af())
/*     */     {
/* 230 */       return true;
/*     */     }
/*     */     
/* 233 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 240 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 246 */     return (TileEntity)new TELoom();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 260 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149643_k(World world, int x, int y, int z) {
/* 269 */     TileEntity te = world.func_147438_o(x, y, z);
/* 270 */     if (te instanceof TELoom)
/* 271 */       return ((TELoom)te).loomType; 
/* 272 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 281 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/* 283 */     int damageValue = func_149643_k(world, x, y, z);
/* 284 */     ret.add(new ItemStack((Block)this, 1, damageValue));
/*     */     
/* 286 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockLoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
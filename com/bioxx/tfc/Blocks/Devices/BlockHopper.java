/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEHopper;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Facing;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockHopper
/*     */   extends BlockTerraContainer
/*     */ {
/*  35 */   private final Random random = new Random();
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static IIcon hopperoutside;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static IIcon hopperTop;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static IIcon hopperInside;
/*     */   
/*     */   public BlockHopper() {
/*  45 */     super(Material.field_151573_f);
/*  46 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess world, int x, int y, int z) {
/*  55 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {
/*  65 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
/*  66 */     super.func_149743_a(world, x, y, z, aabb, list, entity);
/*  67 */     float f = 0.125F;
/*  68 */     func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*  69 */     super.func_149743_a(world, x, y, z, aabb, list, entity);
/*  70 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
/*  71 */     super.func_149743_a(world, x, y, z, aabb, list, entity);
/*  72 */     func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  73 */     super.func_149743_a(world, x, y, z, aabb, list, entity);
/*  74 */     func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
/*  75 */     super.func_149743_a(world, x, y, z, aabb, list, entity);
/*  76 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta) {
/*  85 */     int j1 = Facing.field_71588_a[side];
/*     */     
/*  87 */     if (j1 == 1)
/*     */     {
/*  89 */       j1 = 0;
/*     */     }
/*     */     
/*  92 */     return j1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
/* 101 */     super.func_149689_a(world, x, y, z, entity, is);
/*     */     
/* 103 */     if (is.func_82837_s()) {
/*     */       
/* 105 */       TEHopper tileentityhopper = getHopperTE((IBlockAccess)world, x, y, z);
/* 106 */       tileentityhopper.setCustomName(is.func_82833_r());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World world, int x, int y, int z) {
/* 116 */     super.func_149726_b(world, x, y, z);
/* 117 */     updatePowerState(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
/* 126 */     TEHopper te = getHopperTE((IBlockAccess)world, x, y, z);
/* 127 */     if (world.field_72995_K) {
/*     */       
/* 129 */       if (te != null && te.pressBlock != null && player.func_70093_af()) {
/*     */         
/* 131 */         te.pressBlock = null;
/* 132 */         te.pressCooldown = 0;
/*     */       } 
/* 134 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 138 */     if (te != null && te.pressCooldown == 0) {
/*     */       
/* 140 */       player.openGui(TerraFirmaCraft.instance, 49, world, x, y, z);
/*     */     }
/* 142 */     else if (te != null && te.pressBlock != null && player.func_70093_af()) {
/*     */       
/* 144 */       TFC_Core.giveItemToPlayer(te.pressBlock, player);
/* 145 */       te.pressBlock = null;
/* 146 */       te.pressCooldown = 0;
/*     */     } 
/*     */     
/* 149 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149695_a(World world, int x, int y, int z, Block block) {
/* 160 */     updatePowerState(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   private void updatePowerState(World world, int x, int y, int z) {
/* 165 */     int meta = world.func_72805_g(x, y, z);
/* 166 */     int dir = getDirectionFromMetadata(meta);
/* 167 */     boolean recievesPower = !world.func_72864_z(x, y, z);
/* 168 */     boolean hopperPower = checkMeta(meta);
/*     */     
/* 170 */     if (recievesPower != hopperPower)
/*     */     {
/* 172 */       world.func_72921_c(x, y, z, dir | (recievesPower ? 0 : 8), 4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149749_a(World world, int x, int y, int z, Block block, int meta) {
/* 179 */     if (world.func_147438_o(x, y, z) instanceof TEHopper) {
/*     */       
/* 181 */       TEHopper te = (TEHopper)world.func_147438_o(x, y, z);
/*     */       
/* 183 */       for (int i1 = 0; i1 < te.func_70302_i_(); i1++) {
/*     */         
/* 185 */         ItemStack itemstack = te.func_70301_a(i1);
/*     */         
/* 187 */         if (itemstack != null)
/*     */         {
/* 189 */           while (itemstack.field_77994_a > 0) {
/*     */             
/* 191 */             int j1 = this.random.nextInt(21) + 10;
/*     */             
/* 193 */             if (j1 > itemstack.field_77994_a)
/*     */             {
/* 195 */               j1 = itemstack.field_77994_a;
/*     */             }
/*     */             
/* 198 */             itemstack.field_77994_a -= j1;
/* 199 */             EntityItem entityitem = new EntityItem(world, (x + 0.5F), (y + 0.5F), (z + 0.5F), new ItemStack(itemstack.func_77973_b(), j1, itemstack.func_77960_j()));
/*     */             
/* 201 */             if (itemstack.func_77942_o())
/*     */             {
/* 203 */               entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
/*     */             }
/*     */ 
/*     */             
/* 207 */             world.func_72838_d((Entity)entityitem);
/*     */           } 
/*     */         }
/*     */       } 
/* 211 */       if (te.pressBlock != null) {
/*     */         
/* 213 */         EntityItem entityitem = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, te.pressBlock);
/* 214 */         world.func_72838_d((Entity)entityitem);
/*     */       } 
/* 216 */       world.func_147453_f(x, y, z, block);
/*     */     } 
/*     */     
/* 219 */     super.func_149749_a(world, x, y, z, block, meta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 228 */     return TFCBlocks.hopperRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 247 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess blockAccess, int x, int y, int z, int side) {
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 268 */     return (side == 1) ? hopperTop : hopperoutside;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getDirectionFromMetadata(int meta) {
/* 273 */     return meta & 0x7;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean checkMeta(int meta) {
/* 278 */     return ((meta & 0x8) != 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149736_g(World world, int x, int y, int z, int meta) {
/* 298 */     return Container.func_94526_b((IInventory)getHopperTE((IBlockAccess)world, x, y, z));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 305 */     hopperoutside = registerer.func_94245_a("hopper_outside");
/* 306 */     hopperTop = registerer.func_94245_a("hopper_top");
/* 307 */     hopperInside = registerer.func_94245_a("hopper_inside");
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon getHopperIcon(String s) {
/* 313 */     return "hopper_outside".equals(s) ? hopperoutside : ("hopper_inside".equals(s) ? hopperInside : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static TEHopper getHopperTE(IBlockAccess access, int x, int y, int z) {
/* 318 */     return (TEHopper)access.func_147438_o(x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149702_O() {
/* 328 */     return "hopper";
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 333 */     return (TileEntity)new TEHopper();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
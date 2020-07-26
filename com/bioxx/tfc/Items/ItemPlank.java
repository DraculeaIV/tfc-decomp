/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.TileEntities.TEWoodConstruct;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
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
/*     */ public class ItemPlank
/*     */   extends ItemTerra
/*     */ {
/*     */   private IIcon[] icons;
/*     */   
/*     */   public boolean func_77648_a(ItemStack is, EntityPlayer player, World world, int i, int j, int k, int side, float hitX, float hitY, float hitZ) {
/*     */     boolean isConstruct = (world.func_147439_a(i, j, k) == TFCBlocks.woodConstruct);
/*     */     int offset = !isConstruct ? 1 : 0;
/*     */     boolean isAir = world.func_147437_c(i, j, k);
/*     */     if (!world.field_72995_K) {
/*     */       int d = TEWoodConstruct.plankDetailLevel;
/*     */       int dd = d * d;
/*     */       int dd2 = dd * 2;
/*     */       float div = 1.0F / d;
/*     */       int x = (int)(hitX / div);
/*     */       int y = (int)(hitY / div);
/*     */       int z = (int)(hitZ / div);
/*     */       hitX = Math.round(hitX * 100.0F) / 100.0F;
/*     */       hitY = Math.round(hitY * 100.0F) / 100.0F;
/*     */       hitZ = Math.round(hitZ * 100.0F) / 100.0F;
/*     */       boolean isEdge = false;
/*     */       if (hitX == 0.0F || hitX == 1.0F || hitY == 0.0F || hitY == 1.0F || hitZ == 0.0F || hitZ == 1.0F) {
/*     */         isEdge = true;
/*     */         isConstruct = true;
/*     */         offset = 1;
/*     */       } 
/*     */       if (side == 0) {
/*     */         if ((!isConstruct && isAir) || (isConstruct && isEdge && world.func_147437_c(i, j - offset, k)))
/*     */           world.func_147449_b(i, j - 1, k, TFCBlocks.woodConstruct); 
/*     */         TileEntity tile = world.func_147438_o(i, j - offset, k);
/*     */         if (!(tile instanceof TEWoodConstruct))
/*     */           return false; 
/*     */         int index = dd + x + z * d;
/*     */         TEWoodConstruct te = (TEWoodConstruct)tile;
/*     */         te.data.set(index);
/*     */         if (index < te.woodTypes.length)
/*     */           te.woodTypes[index] = (byte)is.func_77960_j(); 
/*     */         NBTTagCompound nbt = new NBTTagCompound();
/*     */         nbt.func_74768_a("index", index);
/*     */         nbt.func_74774_a("meta", (byte)is.func_77960_j());
/*     */         te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*     */       } else if (side == 1) {
/*     */         if ((!isConstruct && isAir) || (isConstruct && isEdge && world.func_147437_c(i, j + offset, k)))
/*     */           world.func_147449_b(i, j + 1, k, TFCBlocks.woodConstruct); 
/*     */         TileEntity tile = world.func_147438_o(i, j + offset, k);
/*     */         if (!(tile instanceof TEWoodConstruct))
/*     */           return false; 
/*     */         int index = dd + x + z * d;
/*     */         TEWoodConstruct te = (TEWoodConstruct)tile;
/*     */         te.data.set(index);
/*     */         te.woodTypes[index] = (byte)is.func_77960_j();
/*     */         NBTTagCompound nbt = new NBTTagCompound();
/*     */         nbt.func_74768_a("index", index);
/*     */         nbt.func_74774_a("meta", (byte)is.func_77960_j());
/*     */         te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*     */       } else if (side == 2) {
/*     */         if ((!isConstruct && isAir) || (isConstruct && isEdge && world.func_147437_c(i, j, k - offset)))
/*     */           world.func_147449_b(i, j, k - 1, TFCBlocks.woodConstruct); 
/*     */         TileEntity tile = world.func_147438_o(i, j, k - offset);
/*     */         if (!(tile instanceof TEWoodConstruct))
/*     */           return false; 
/*     */         int index = dd2 + x + y * d;
/*     */         TEWoodConstruct te = (TEWoodConstruct)tile;
/*     */         te.data.set(index);
/*     */         te.woodTypes[index] = (byte)is.func_77960_j();
/*     */         NBTTagCompound nbt = new NBTTagCompound();
/*     */         nbt.func_74768_a("index", index);
/*     */         nbt.func_74774_a("meta", (byte)is.func_77960_j());
/*     */         te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*     */       } else if (side == 3) {
/*     */         if ((!isConstruct && isAir) || (isConstruct && isEdge && world.func_147437_c(i, j, k + offset)))
/*     */           world.func_147449_b(i, j, k + 1, TFCBlocks.woodConstruct); 
/*     */         TileEntity tile = world.func_147438_o(i, j, k + offset);
/*     */         if (!(tile instanceof TEWoodConstruct))
/*     */           return false; 
/*     */         int index = dd2 + x + y * d;
/*     */         TEWoodConstruct te = (TEWoodConstruct)tile;
/*     */         te.data.set(index);
/*     */         te.woodTypes[index] = (byte)is.func_77960_j();
/*     */         NBTTagCompound nbt = new NBTTagCompound();
/*     */         nbt.func_74768_a("index", index);
/*     */         nbt.func_74774_a("meta", (byte)is.func_77960_j());
/*     */         te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*     */       } else if (side == 4) {
/*     */         if ((!isConstruct && isAir) || (isConstruct && isEdge && world.func_147437_c(i - offset, j, k)))
/*     */           world.func_147449_b(i - 1, j, k, TFCBlocks.woodConstruct); 
/*     */         TileEntity tile = world.func_147438_o(i - offset, j, k);
/*     */         if (!(tile instanceof TEWoodConstruct))
/*     */           return false; 
/*     */         int index = y + z * d;
/*     */         TEWoodConstruct te = (TEWoodConstruct)tile;
/*     */         te.data.set(index);
/*     */         te.woodTypes[index] = (byte)is.func_77960_j();
/*     */         NBTTagCompound nbt = new NBTTagCompound();
/*     */         nbt.func_74768_a("index", index);
/*     */         nbt.func_74774_a("meta", (byte)is.func_77960_j());
/*     */         te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*     */       } else if (side == 5) {
/*     */         if ((!isConstruct && isAir) || (isConstruct && isEdge && world.func_147437_c(i + offset, j, k)))
/*     */           world.func_147449_b(i + 1, j, k, TFCBlocks.woodConstruct); 
/*     */         TileEntity tile = world.func_147438_o(i + offset, j, k);
/*     */         if (!(tile instanceof TEWoodConstruct))
/*     */           return false; 
/*     */         int index = y + z * d;
/*     */         TEWoodConstruct te = (TEWoodConstruct)tile;
/*     */         te.data.set(index);
/*     */         te.woodTypes[index] = (byte)is.func_77960_j();
/*     */         NBTTagCompound nbt = new NBTTagCompound();
/*     */         nbt.func_74768_a("index", index);
/*     */         nbt.func_74774_a("meta", (byte)is.func_77960_j());
/*     */         te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt));
/*     */       } 
/*     */       is.field_77994_a--;
/*     */       return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public ItemPlank() {
/* 221 */     this.icons = new IIcon[Global.WOOD_ALL.length]; this.field_77787_bX = true; func_77656_e(0);
/*     */     func_77637_a(TFCTabs.TFC_MATERIALS);
/*     */     this.metaNames = (String[])Global.WOOD_ALL.clone();
/*     */     setWeight(EnumWeight.LIGHT);
/* 225 */     setSize(EnumSize.MEDIUM); } public void func_94581_a(IIconRegister registerer) { for (int i = 0; i < Global.WOOD_ALL.length; i++)
/* 226 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/" + Global.WOOD_ALL[i] + " Plank");  }
/*     */    public int func_77647_b(int i) {
/*     */     return i;
/*     */   } public IIcon func_77617_a(int meta) {
/*     */     return this.icons[meta];
/*     */   }
/*     */   public void func_150895_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 233 */     for (int i = 0; i < Global.WOOD_ALL.length; i++)
/* 234 */       list.add(new ItemStack(this, 1, i)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemPlank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
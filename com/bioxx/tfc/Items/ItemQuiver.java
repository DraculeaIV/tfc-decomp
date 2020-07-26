/*     */ package com.bioxx.tfc.Items;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Enums.EnumAmmo;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.Interfaces.IQuiverAmmo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemQuiver
/*     */   extends ItemTerra
/*     */   implements IEquipable
/*     */ {
/*     */   public ItemQuiver() {
/*  30 */     func_77637_a(TFCTabs.TFC_ARMOR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_77618_c(int par1, int par2) {
/*  38 */     return this.field_77791_bV;
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
/*     */   public void func_77663_a(ItemStack is, World world, Entity entity, int i, boolean isSelected) {
/*  52 */     super.func_77663_a(is, world, entity, i, isSelected);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
/*  58 */     entityplayer.openGui(TerraFirmaCraft.instance, 40, entityplayer.field_70170_p, (int)entityplayer.field_70165_t, (int)entityplayer.field_70163_u, (int)entityplayer.field_70161_v);
/*  59 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  65 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:quiver");
/*     */   }
/*     */   
/*     */   public int getQuiverArrows(ItemStack item) {
/*  69 */     int n = 0;
/*  70 */     ItemStack[] inventory = loadInventory(item);
/*  71 */     for (ItemStack i : inventory) {
/*  72 */       if (i != null && i.func_77973_b() instanceof ItemArrow)
/*  73 */         n += i.field_77994_a; 
/*     */     } 
/*  75 */     return n;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getQuiverJavelins(ItemStack item) {
/*  80 */     int n = 0;
/*  81 */     ItemStack[] inventory = loadInventory(item);
/*  82 */     for (ItemStack i : inventory) {
/*  83 */       if (i != null && i.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemJavelin)
/*  84 */         n += i.field_77994_a; 
/*     */     } 
/*  86 */     return n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List[] getQuiverJavelinTypes(ItemStack item) {
/*  93 */     ArrayList[] pair = new ArrayList[2];
/*  94 */     ArrayList<String> list = new ArrayList<String>();
/*  95 */     ArrayList<Integer> listNum = new ArrayList<Integer>();
/*  96 */     ItemStack[] inventory = loadInventory(item);
/*  97 */     for (ItemStack i : inventory) {
/*     */       
/*  99 */       if (i != null && i.func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemJavelin) {
/*     */         
/* 101 */         String s = i.func_77973_b().func_77653_i(i);
/* 102 */         if (!list.contains(s))
/* 103 */           list.add(s); 
/* 104 */         int n = list.indexOf(s);
/* 105 */         if (listNum.size() == n)
/* 106 */           listNum.add(Integer.valueOf(0)); 
/* 107 */         listNum.set(n, Integer.valueOf(((Integer)listNum.get(n)).intValue() + 1));
/*     */       } 
/*     */     } 
/* 110 */     pair[0] = list;
/* 111 */     pair[1] = listNum;
/* 112 */     return (List[])pair;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/* 118 */     ItemTerra.addSizeInformation(is, arraylist);
/*     */     
/* 120 */     if (TFC_Core.showShiftInformation()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 127 */       arraylist.add(EnumChatFormatting.WHITE + TFC_Core.translate("gui.Advanced") + ":");
/* 128 */       arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Bow.Arrows") + ": " + EnumChatFormatting.YELLOW + getQuiverArrows(is));
/* 129 */       arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Bow.Javelins") + ": " + EnumChatFormatting.YELLOW + getQuiverJavelins(is));
/* 130 */       List[] javData = getQuiverJavelinTypes(is);
/* 131 */       for (int i = 0; i < javData[0].size(); i++) {
/*     */         
/* 133 */         String s = javData[0].get(i);
/* 134 */         int n = ((Integer)javData[1].get(i)).intValue();
/* 135 */         arraylist.add(EnumChatFormatting.ITALIC + "  -" + s + ": " + EnumChatFormatting.YELLOW + n);
/*     */       } 
/* 137 */       if (is.func_77942_o()) {
/*     */         
/* 139 */         NBTTagCompound stackTagCompound = is.func_77978_p();
/* 140 */         if (stackTagCompound.func_74764_b("creator")) {
/* 141 */           arraylist.add(EnumChatFormatting.ITALIC + TFC_Core.translate("gui.Armor.ForgedBy") + " " + stackTagCompound.func_74779_i("creator"));
/*     */         }
/*     */       } 
/*     */     } else {
/* 145 */       arraylist.add(EnumChatFormatting.DARK_GRAY + TFC_Core.translate("gui.Advanced") + ": (" + TFC_Core.translate("gui.Hold") + " " + EnumChatFormatting.GRAY + TFC_Core.translate("gui.Shift") + EnumChatFormatting.DARK_GRAY + ")");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack addItem(ItemStack quiver, ItemStack ammo) {
/* 152 */     ItemStack[] inventory = loadInventory(quiver);
/* 153 */     for (int i = 0; i < inventory.length && ammo != null; i++) {
/*     */       
/* 155 */       if (inventory[i] != null && inventory[i].func_77969_a(ammo)) {
/*     */         
/* 157 */         if (ammo.field_77994_a + (inventory[i]).field_77994_a <= ammo.func_77976_d())
/*     */         {
/* 159 */           (inventory[i]).field_77994_a += ammo.field_77994_a;
/* 160 */           ammo = null;
/*     */         }
/* 162 */         else if (ammo.field_77994_a + (inventory[i]).field_77994_a > ammo.func_77976_d())
/*     */         {
/* 164 */           int diff = ammo.func_77976_d() - (inventory[i]).field_77994_a;
/* 165 */           (inventory[i]).field_77994_a = ammo.func_77976_d();
/* 166 */           ammo.field_77994_a -= diff;
/*     */         }
/*     */       
/* 169 */       } else if (inventory[i] == null) {
/*     */         
/* 171 */         inventory[i] = ammo.func_77946_l();
/* 172 */         ammo = null;
/*     */       } 
/*     */     } 
/* 175 */     saveInventory(quiver, inventory);
/* 176 */     return ammo;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack consumeAmmo(ItemStack quiver, EnumAmmo ammoType, boolean shouldConsume) {
/* 181 */     ItemStack[] inventory = loadInventory(quiver);
/* 182 */     for (int i = 0; i < inventory.length; i++) {
/*     */       
/* 184 */       if (inventory[i] != null && inventory[i].func_77973_b() instanceof IQuiverAmmo && ((IQuiverAmmo)inventory[i].func_77973_b()).getAmmoType() == ammoType) {
/*     */         
/* 186 */         ItemStack out = inventory[i].func_77946_l();
/* 187 */         out.field_77994_a = 1;
/* 188 */         if (shouldConsume)
/* 189 */           (inventory[i]).field_77994_a--; 
/* 190 */         if ((inventory[i]).field_77994_a <= 0)
/* 191 */           inventory[i] = null; 
/* 192 */         saveInventory(quiver, inventory);
/* 193 */         return out;
/*     */       } 
/*     */     } 
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack[] loadInventory(ItemStack quiver) {
/* 201 */     ItemStack[] inventory = new ItemStack[8];
/* 202 */     NBTTagCompound nbt = quiver.func_77978_p();
/* 203 */     if (nbt != null && nbt.func_74764_b("Items")) {
/*     */       
/* 205 */       NBTTagList nbttaglist = nbt.func_150295_c("Items", 10);
/*     */       
/* 207 */       for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/*     */         
/* 209 */         NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 210 */         byte byte0 = nbttagcompound1.func_74771_c("Slot");
/* 211 */         if (byte0 >= 0 && byte0 < 8)
/* 212 */           inventory[byte0] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */       } 
/*     */     } 
/* 215 */     return inventory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveInventory(ItemStack quiver, ItemStack[] inventory) {
/* 220 */     NBTTagList nbttaglist = new NBTTagList();
/* 221 */     for (int i = 0; i < inventory.length; i++) {
/*     */       
/* 223 */       if (inventory[i] != null) {
/*     */         
/* 225 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 226 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 227 */         inventory[i].func_77955_b(nbttagcompound1);
/* 228 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/* 231 */     if (quiver != null) {
/*     */       
/* 233 */       if (!quiver.func_77942_o())
/* 234 */         quiver.func_77982_d(new NBTTagCompound()); 
/* 235 */       quiver.func_77978_p().func_74782_a("Items", (NBTBase)nbttaglist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IEquipable.EquipType getEquipType(ItemStack is) {
/* 242 */     return IEquipable.EquipType.BACK;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEquippedRender() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTooHeavyToCarry(ItemStack is) {
/* 252 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/* 258 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/* 264 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemQuiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
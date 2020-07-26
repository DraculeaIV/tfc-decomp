/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Crafting.AnvilManager;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.Enums.EnumWeight;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCustomPickaxe
/*     */   extends ItemPickaxe
/*     */   implements ISize
/*     */ {
/*     */   public ItemCustomPickaxe(Item.ToolMaterial e) {
/*  34 */     super(e);
/*  35 */     func_77637_a(TFCTabs.TFC_TOOLS);
/*  36 */     setNoRepair();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister registerer) {
/*  42 */     this.field_77791_bV = registerer.func_94245_a("terrafirmacraft:tools/" + func_77658_a().replace("item.", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon getIcon(ItemStack stack, int pass) {
/*  48 */     NBTTagCompound nbt = stack.func_77978_p();
/*  49 */     if (pass == 1 && nbt != null && nbt.func_74764_b("broken")) {
/*  50 */       return TFC_Textures.brokenItem;
/*     */     }
/*  52 */     return func_77618_c(stack.func_77960_j(), pass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77624_a(ItemStack is, EntityPlayer player, List<String> arraylist, boolean flag) {
/*  58 */     ItemTerra.addSizeInformation(is, arraylist);
/*  59 */     ItemTerraTool.addSmithingBonusInformation(is, arraylist);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  65 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77639_j() {
/*  77 */     if (canStack()) {
/*  78 */       return (getSize((ItemStack)null)).stackSize * (getWeight((ItemStack)null)).multiplier;
/*     */     }
/*  80 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumWeight getWeight(ItemStack is) {
/*  86 */     return EnumWeight.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxDamage(ItemStack stack) {
/*  92 */     return (int)(func_77612_l() + func_77612_l() * AnvilManager.getDurabilityBuff(stack));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDigSpeed(ItemStack stack, Block block, int meta) {
/*  98 */     float digSpeed = super.getDigSpeed(stack, block, meta);
/*     */     
/* 100 */     if (ForgeHooks.isToolEffective(stack, block, meta))
/*     */     {
/* 102 */       return digSpeed + digSpeed * AnvilManager.getDurabilityBuff(stack);
/*     */     }
/* 104 */     return digSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 110 */     return EnumItemReach.MEDIUM;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 118 */     boolean placed = false;
/* 119 */     int toolSlot = player.field_71071_by.field_70461_c;
/* 120 */     int nextSlot = (toolSlot == 0) ? 8 : (toolSlot + 1);
/* 121 */     ItemStack nextSlotStack = null;
/*     */     
/* 123 */     if (toolSlot < 8) {
/*     */       
/* 125 */       nextSlotStack = player.field_71071_by.func_70301_a(nextSlot);
/* 126 */       if (nextSlotStack != null) {
/*     */         
/* 128 */         Item item = nextSlotStack.func_77973_b();
/*     */         
/* 130 */         if (item instanceof ItemBlock) {
/*     */           
/* 132 */           int posX = x;
/* 133 */           int posY = y;
/* 134 */           int posZ = z;
/*     */           
/* 136 */           switch (side) {
/*     */             
/*     */             case 0:
/* 139 */               posY--;
/*     */               break;
/*     */             case 1:
/* 142 */               posY++;
/*     */               break;
/*     */             case 2:
/* 145 */               posZ--;
/*     */               break;
/*     */             case 3:
/* 148 */               posZ++;
/*     */               break;
/*     */             case 4:
/* 151 */               posX--;
/*     */               break;
/*     */             case 5:
/* 154 */               posX++;
/*     */               break;
/*     */           } 
/*     */           
/* 158 */           AxisAlignedBB blockBounds = AxisAlignedBB.func_72330_a(posX, posY, posZ, (posX + 1), (posY + 1), (posZ + 1));
/* 159 */           AxisAlignedBB playerBounds = player.field_70121_D;
/*     */           
/* 161 */           if (item instanceof ItemBlock) {
/*     */             
/* 163 */             Block blockToPlace = ((ItemBlock)item).field_150939_a;
/* 164 */             if (blockToPlace.func_149688_o().func_76230_c())
/*     */             {
/* 166 */               if (playerBounds.func_72326_a(blockBounds)) {
/* 167 */                 return false;
/*     */               }
/*     */             }
/*     */           } 
/* 171 */           int dmg = nextSlotStack.func_77960_j();
/* 172 */           int count = nextSlotStack.field_77994_a;
/*     */           
/* 174 */           placed = item.func_77648_a(nextSlotStack, player, world, x, y, z, side, hitX, hitY, hitZ);
/*     */           
/* 176 */           if (player.field_71075_bZ.field_75098_d) {
/*     */             
/* 178 */             nextSlotStack.func_77964_b(dmg);
/* 179 */             nextSlotStack.field_77994_a = count;
/*     */           } 
/* 181 */           if (nextSlotStack.field_77994_a < 1) {
/*     */             
/* 183 */             nextSlotStack = null;
/* 184 */             player.field_71071_by.func_70299_a(nextSlot, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 189 */     return placed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemCustomPickaxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
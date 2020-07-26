/*     */ package com.bioxx.tfc.GUI;
/*     */ 
/*     */ import com.bioxx.tfc.Containers.ContainerSpecialCrafting;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.KnappingUpdatePacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.TFCItems;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.ReflectionHelper;
/*     */ import java.lang.reflect.Field;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.GuiScreenEvent;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiKnapping
/*     */   extends GuiContainerTFC
/*     */ {
/*     */   private boolean previouslyLoaded;
/*  28 */   public static ResourceLocation texture = new ResourceLocation("terrafirmacraft", "textures/gui/gui_knapping.png");
/*  29 */   private final Field _selectedButton = ReflectionHelper.findField(GuiScreen.class, new String[] { "selectedButton", "field_146290_a" });
/*     */ 
/*     */   
/*     */   public GuiKnapping(InventoryPlayer inventoryplayer, ItemStack is, World world, int x, int y, int z) {
/*  33 */     super((Container)new ContainerSpecialCrafting(inventoryplayer, is, world, x, y, z), 176, 103);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/*  39 */     (PlayerManagerTFC.getInstance().getClientPlayer()).knappingInterface = new boolean[25];
/*  40 */     super.func_146281_b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  46 */     super.func_73866_w_();
/*     */     
/*  48 */     this.field_146292_n.clear();
/*  49 */     ((ContainerSpecialCrafting)this.field_147002_h).setDecreasedStack(Boolean.valueOf(false));
/*     */     
/*  51 */     for (int y = 0; y < 5; y++) {
/*     */       
/*  53 */       for (int x = 0; x < 5; x++) {
/*     */         
/*  55 */         this.field_146292_n.add(new GuiKnappingButton(x + y * 5, this.field_147003_i + x * 16 + 10, this.field_147009_r + y * 16 + 12, 16, 16));
/*     */         
/*  57 */         if (!this.previouslyLoaded) {
/*     */           
/*  59 */           if ((PlayerManagerTFC.getInstance().getClientPlayer()).knappingInterface[y * 5 + x])
/*     */           {
/*  61 */             resetButton(y * 5 + x);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*  71 */         else if ((PlayerManagerTFC.getInstance().getClientPlayer()).specialCraftingType.func_77973_b() != TFCItems.flatClay && ((ContainerSpecialCrafting)this.field_147002_h).craftMatrix
/*  72 */           .func_70301_a(y * 5 + x) == null) {
/*     */           
/*  74 */           resetButton(y * 5 + x);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  80 */     this.previouslyLoaded = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton guibutton) {
/*  86 */     resetButton(guibutton.field_146127_k);
/*  87 */     KnappingUpdatePacket knappingUpdatePacket = new KnappingUpdatePacket(guibutton.field_146127_k);
/*  88 */     TerraFirmaCraft.PACKET_PIPELINE.sendToServer((AbstractPacket)knappingUpdatePacket);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetButton(int id) {
/*  93 */     if ((PlayerManagerTFC.getInstance().getClientPlayer()).specialCraftingTypeAlternate == null)
/*     */     {
/*  95 */       ((GuiKnappingButton)this.field_146292_n.get(id)).field_146125_m = false;
/*     */     }
/*  97 */     (PlayerManagerTFC.getInstance().getClientPlayer()).knappingInterface[id] = true;
/*  98 */     ((GuiKnappingButton)this.field_146292_n.get(id)).field_146124_l = false;
/*  99 */     ((ContainerSpecialCrafting)this.field_147002_h).craftMatrix.func_70299_a(id, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float f, int p, int j) {
/* 105 */     drawGui(texture);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_146983_a(int par1) {
/* 115 */     if (this.field_146297_k.field_71439_g.field_71071_by.field_70461_c != par1 - 2) {
/*     */       
/* 117 */       super.func_146983_a(par1);
/* 118 */       return true;
/*     */     } 
/*     */     
/* 121 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146273_a(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
/* 127 */     if (clickedMouseButton == 0)
/*     */     {
/* 129 */       for (int i = 0; i < this.field_146292_n.size(); i++) {
/*     */         
/* 131 */         if (this.field_146292_n.get(i) instanceof GuiButton) {
/*     */           
/* 133 */           GuiButton guiButton = this.field_146292_n.get(i);
/*     */           
/* 135 */           if (guiButton.func_146116_c(this.field_146297_k, mouseX, mouseY))
/*     */             
/*     */             try {
/*     */               
/* 139 */               GuiScreenEvent.ActionPerformedEvent.Pre event = new GuiScreenEvent.ActionPerformedEvent.Pre((GuiScreen)this, guiButton, this.field_146292_n);
/* 140 */               if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */                 break; 
/* 142 */               if (this._selectedButton.get(this) != event.button)
/*     */               
/*     */               { 
/* 145 */                 func_146286_b(mouseX, mouseY, 0);
/*     */                 
/* 147 */                 this._selectedButton.set(this, event.button);
/* 148 */                 event.button.func_146113_a(this.field_146297_k.func_147118_V());
/* 149 */                 func_146284_a(event.button);
/* 150 */                 if (equals(this.field_146297_k.field_71462_r))
/* 151 */                   MinecraftForge.EVENT_BUS.post((Event)new GuiScreenEvent.ActionPerformedEvent.Post((GuiScreen)this, event.button, this.field_146292_n));  } 
/* 152 */             } catch (Exception e) {
/*     */               
/* 154 */               throw new RuntimeException(e);
/*     */             }  
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\GUI\GuiKnapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
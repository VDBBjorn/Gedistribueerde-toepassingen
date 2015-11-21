<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Leden.aspx.cs" Inherits="BadmintonWebClient.Leden" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
    <div>
    <asp:Label ID="Label1" runat="server" Text="Ploegid: "></asp:Label>
        <asp:TextBox ID="InvoerClub" runat="server"></asp:TextBox> 
        <asp:Button ID="SelecteerKnop" runat="server" Text="Selecteer Leden" 
            onclick="SelecteerKnop_Click" />
    </div>
    <asp:GridView ID="OverzichtLeden" runat="server">
    </asp:GridView>

</asp:Content>

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using BadmintonWebClient.BadmintonServiceReference;

namespace BadmintonWebClient
{
    public partial class Leden : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void SelecteerKnop_Click(object sender, EventArgs e)
        {
            BadmintonServiceClient client = new BadmintonServiceClient();
            OverzichtLeden.DataSource = client.GetLeden(Convert.ToInt32(InvoerClub.Text));
            OverzichtLeden.DataBind();
        }

    }
}
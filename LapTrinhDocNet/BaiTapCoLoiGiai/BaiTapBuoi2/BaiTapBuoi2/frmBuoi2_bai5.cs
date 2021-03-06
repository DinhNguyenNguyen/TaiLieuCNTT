using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaiTapBuoi2
{
    public partial class frmBuoi2_bai5 : Form
    {
        public frmBuoi2_bai5()
        {
            InitializeComponent();
        }

        private void btnTong_Click(object sender, EventArgs e)
        {
            int n = Int32.Parse(txtNhap.Text);
            int tong = 0;
            for (int i = 1; i <= n; i++)
            {
                tong += i;
                if (i == n)
                {
                    txtKQ1.Text += i + " ";
                }
                else
                {
                    txtKQ1.Text += i + " + ";
                }

            }
            txtKQ2.Text = tong.ToString();
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            txtNhap.Clear();
            txtKQ1.Clear();
            txtKQ2.Clear();
            txtNhap.Focus();
        }
    }
}

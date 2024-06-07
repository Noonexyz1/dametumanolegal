import { Cell, Pie, PieChart, ResponsiveContainer, Tooltip } from "recharts"

const dataPay = [
    { name: "Group A", value: 2400 },
    { name: 'Group B', value: 4567 },
    { name: 'Group C', value: 1398 },
    { name: 'Group D', value: 9800 },
    { name: 'Group E', value: 3908 },
    { name: 'Group F', value: 4800 },
]
const COLORS = ['#ce93d8', '#5c6bc0', '#b39ddb', '#4dd0e1', '#f48fb1', '#d500f9']

export default function PieChartGraf() {
    return (
        <div>
            <h3 className='text-2xl text-white pt-4 pl-2'>Titulo torta</h3>
            <div className="sm:mx-auto flex flex-row justify-start border border-white rounded-2xl h-72 my-2 mx-2">
                <ResponsiveContainer>
                    <PieChart>
                        <Pie
                            dataKey="value"
                            data={dataPay}
                            innerRadius={60}
                            outerRadius={120}
                            fill="#82ca9d"
                        >
                            {dataPay.map((entry, index) => (
                                <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
                            ))}
                        </Pie>
                        <Tooltip />
                    </PieChart>
                </ResponsiveContainer>
            </div>
        </div>

    )
}